package com.guiguselection.controller

import com.guiguselection.ApiResponse
import com.guiguselection.entity.User
import com.guiguselection.interfaces.UserRepository
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user")
class UserController {

    @Autowired
    private lateinit var userRepository: UserRepository

    @PostMapping("/register")
    fun registerUser(@Valid @RequestBody newUser: User): ApiResponse<String> {
        // 检查用户名是否已存在
        if (userRepository.findByUsername(newUser.username) != null) {
            return ApiResponse(400, message = "用户名已存在")
        }

        // 保存新用户到数据库
        userRepository.save(newUser)

        return ApiResponse(201, message = "用户注册成功")
    }

    @PostMapping("/login")
    fun login(@RequestBody requestBody: Map<String, String>): ApiResponse<String> {
        val username = requestBody["username"]
        val password = requestBody["password"]

        val user = userRepository.findByUsername(username ?: "")

        return if (user != null && user.passwd == password) {
            ApiResponse(200, user.token)
        } else {
            ApiResponse(401, message = "账号或者密码不正确")
        }
    }

    @GetMapping("/info")
    fun getUserInfo(@RequestHeader("token") token: String): ApiResponse<User> {
        val user = userRepository.findByToken(token)

        return if (user != null) {
            ApiResponse(200, user)
        } else {
            ApiResponse(401, message = "获取用户信息失败")
        }
    }
}
