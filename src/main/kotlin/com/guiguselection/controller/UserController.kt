package com.guiguselection.controller

import org.springframework.web.bind.annotation.*

data class User(
    val userId: Long,
    val avatar: String,
    val username: String,
    val password: String,
    val desc: String,
    val roles: List<String>,
    val buttons: List<String>,
    val routes: List<String>,
    val token: String
)

data class ApiResponse<T>(
    val status: Int,
    val data: T? = null,
    val message: String? = null
)

@RestController
@RequestMapping("/api/user")
class UserController {

    // 模拟用户列表
    private val userList = listOf(
        User(
            userId = 1,
            avatar = "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif",
            username = "admin",
            password = "111111",
            desc = "平台管理员",
            roles = listOf("平台管理员"),
            buttons = listOf("cuser.detail"),
            routes = listOf("home"),
            token = "Admin Token"
        )
    )

    @PostMapping("/login")
    fun login(@RequestBody requestBody: Map<String, String>): ApiResponse<String> {
        val username = requestBody["username"]
        val password = requestBody["password"]

        val user = userList.find { it.username == username && it.password == password }

        return if (user != null) {
            ApiResponse(200, user.token)
        } else {
            ApiResponse(401, message = "账号或者密码不正确")
        }
    }

    @GetMapping("/info")
    fun getUserInfo(@RequestHeader("token") token: String): ApiResponse<User> {
        val user = userList.find { it.token == token }

        return if (user != null) {
            ApiResponse(200, user)
        } else {
            ApiResponse(401, message = "获取用户信息失败")
        }
    }
}
