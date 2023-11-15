package com.guiguselection

import com.guiguselection.entity.User
import com.guiguselection.interfaces.UserService
import com.guiguselection.interfaces.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(@Autowired private val userRepository: UserRepository) : UserService {

    override fun getAllUsers(): List<User> {
        // 使用 Spring Data JPA 查询所有用户
        return userRepository.findAll()
    }
}
