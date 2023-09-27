package com.guiguselection.controller

import org.springframework.web.bind.annotation.CrossOrigin

@CrossOrigin(origins = ["*"]) // 允许所有来源的跨域请求，你也可以根据需要指定具体的来源
abstract class BaseController {
    // 添加其他通用的配置或方法
}