package com.guiguselection.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/other")
class OtherController {

    @GetMapping("/someEndpoint")
    fun someEndpoint(): String {
        return "这是一个其他接口"
    }

    // 添加其他非用户相关的接口方法
}
