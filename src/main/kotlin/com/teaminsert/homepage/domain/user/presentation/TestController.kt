package com.teaminsert.homepage.domain.user.presentation

import com.teaminsert.homepage.global.config.properties.JwtProperties
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/test")
@RestController
class TestController(
        private val jwtProperties: JwtProperties
) {
    @GetMapping
    fun test() = jwtProperties.accessTime
}