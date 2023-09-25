package com.guiguselection.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MyController {
    @GetMapping("/")
    fun rootPath(): String {
        return "这是一个主页"
    }
}
