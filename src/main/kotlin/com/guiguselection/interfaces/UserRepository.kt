package com.guiguselection.interfaces

import com.guiguselection.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>
