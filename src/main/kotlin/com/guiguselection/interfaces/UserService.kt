package com.guiguselection.interfaces

import com.guiguselection.entity.User

interface UserService {
    fun getAllUsers(): List<User>
}