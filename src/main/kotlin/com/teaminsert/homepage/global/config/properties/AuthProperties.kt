package com.teaminsert.homepage.global.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("auth")
class AuthProperties(
        val google: Google
) {
    class Google(
            val baseUrl: String,
            val clientId: String,
            val redirectUrl: String
    ) {
    }
}