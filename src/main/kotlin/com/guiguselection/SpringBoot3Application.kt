package com.guiguselection

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EntityScan(basePackages = ["com.guiguselection"])
@EnableJpaRepositories(basePackages = ["com.guiguselection.repository"])
class SpringBoot3Application {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(SpringBoot3Application::class.java, *args)
            println("Server is running at http://127.0.0.1:8080/")
        }
    }
}
