package com.teaminsert.homepage.global.config

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@EnableFeignClients(basePackages = ["com.teaminsert.homepage.global.feign"])
@Configuration
class FeignConfig {
}