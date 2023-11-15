package com.guiguselection.controller

import com.guiguselection.interfaces.UserService
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("")
class HomeController(private val userService: UserService) : BaseController() {

    @GetMapping("/")
    fun home(): String {
        return "这是一个主页"
    }

    @GetMapping("/users")
    fun displayUsers(model: Model): String {
        val userList = userService.getAllUsers()
        model.addAttribute("users", userList)
        return "userList"
    }
}