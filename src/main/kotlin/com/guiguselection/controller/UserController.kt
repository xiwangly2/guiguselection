package com.guiguselection.controller

import com.guiguselection.ApiResponse
import com.guiguselection.entity.User
import com.guiguselection.interfaces.UserRepository
import jakarta.validation.Valid
import org.bouncycastle.crypto.generators.Argon2BytesGenerator
import org.bouncycastle.crypto.params.Argon2Parameters
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.security.SecureRandom
import java.util.*

@Controller
@RequestMapping("/api/user")
class UserController : BaseController() {

    @Autowired
    private lateinit var userRepository: UserRepository

    @PostMapping("/register")
    fun registerUser(@Valid @RequestBody newUser: User): ApiResponse<String> {
        // 检查用户名是否已存在
        if (userRepository.findByUsername(newUser.username) != null) {
            return ApiResponse(400, message = "用户名已存在")
        }

        // 生成密码哈希
        val hashedPassword = hashPassword(newUser.passwd)
        newUser.passwd = hashedPassword

        // 保存新用户到数据库
        userRepository.save(newUser)

        return ApiResponse(201, message = "用户注册成功")
    }

    @PostMapping("/login")
    fun login(@RequestBody requestBody: Map<String, String>): ApiResponse<String> {
        val username = requestBody["username"]
        val passwd = requestBody["passwd"]

        val user = userRepository.findByUsername(username ?: "")

        return if (user != null && checkPassword(passwd, user.passwd)) {
            ApiResponse(200, user.token)
        } else {
            ApiResponse(401, message = "账号或者密码不正确")
        }
    }

    @RequestMapping("/info")
    fun getUserInfo(@RequestHeader("token") token: String): ApiResponse<User> {
        val user = userRepository.findByToken(token)

        return if (user != null) {
            ApiResponse(200, user)
        } else {
            ApiResponse(401, message = "获取用户信息失败")
        }
    }

    // 添加一个GetMapping方法来列出所有用户
//    @RequestMapping("/list")
//    fun listUsers(): ApiResponse<List<User>> {
//        val users = userRepository.findAll()
//        return ApiResponse(200, users)
//    }
    @GetMapping("/list")
    fun listUsers(model: Model): String {
        val users = userRepository.findAll()
        model.addAttribute("users", users)
        return "userList"
    }

    private fun hashPassword(password: String): String {
        // 创建随机盐值
        val salt = generateSalt()

        // 配置Argon2参数
        val parameters = configureArgon2Parameters(salt)

        // 计算哈希值
        val hash = calculateArgon2Hash(password, parameters)

        // 返回哈希值和盐值的Base64编码
        val saltBase64 = Base64.getEncoder().encodeToString(salt)
        val hashBase64 = Base64.getEncoder().encodeToString(hash)

        return "$saltBase64:$hashBase64"
    }

    private fun checkPassword(enteredPassword: String?, storedHashedPassword: String): Boolean {
        // 从存储的哈希密码中提取盐值
        val parts = storedHashedPassword.split(":")
        if (parts.size != 2) {
            return false // 无效的哈希密码格式
        }

        val salt = Base64.getDecoder().decode(parts[0])

        // 配置Argon2参数
        val parameters = configureArgon2Parameters(salt)

        // 计算用户输入密码的哈希值
        val hash = calculateArgon2Hash(enteredPassword, parameters)

        // 将用户输入密码的哈希值与存储的哈希值进行比较
        val enteredPasswordHash = Base64.getEncoder().encodeToString(hash)

        return enteredPasswordHash == parts[1]
    }

    private fun generateSalt(): ByteArray {
        val random = SecureRandom()
        val salt = ByteArray(32) // 盐值长度可以根据需要调整
        random.nextBytes(salt)
        return salt
    }

    private fun configureArgon2Parameters(salt: ByteArray): Argon2Parameters {
        return Argon2Parameters.Builder(Argon2Parameters.ARGON2_id)
            .withVersion(Argon2Parameters.ARGON2_VERSION_13)
            .withMemoryAsKB(65536) // 内存成本，根据需要调整
            .withIterations(4) // 迭代次数，根据需要调整
            .withSalt(salt)
            .build()
    }

    private fun calculateArgon2Hash(password: String?, parameters: Argon2Parameters): ByteArray {
        val generator = Argon2BytesGenerator()
        generator.init(parameters)
        val hash = ByteArray(64) // 输出长度为64个字节
        generator.generateBytes(password?.toByteArray(), hash)
        return hash
    }
}
