package com.guiguselection.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("")
class HomeController {

    @RequestMapping("/")
    fun someEndpoint(): String {
        return "这是一个主页"
    }

    // 添加其他非用户相关的接口方法
}