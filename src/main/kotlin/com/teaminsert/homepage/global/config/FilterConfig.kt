package com.teaminsert.homepage.global.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.teaminsert.homepage.global.config.error.GlobalExceptionFilter
import com.teaminsert.homepage.global.security.jwt.JwtTokenFilter
import com.teaminsert.homepage.global.security.jwt.JwtTokenProvider
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
class FilterConfig(
        private val objectMapper: ObjectMapper,
        private val jwtTokenProvider: JwtTokenProvider
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(builder: HttpSecurity) {
        builder.addFilterBefore(JwtTokenFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter::class.java)
        builder.addFilterBefore(GlobalExceptionFilter(objectMapper), JwtTokenFilter::class.java)
    }
}