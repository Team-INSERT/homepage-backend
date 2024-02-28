package com.teaminsert.homepage.global.config

import com.teaminsert.homepage.global.security.jwt.JwtTokenFilter
import com.teaminsert.homepage.global.security.jwt.JwtTokenProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.HttpStatusEntryPoint
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig(
        private val jwtProvider: JwtTokenProvider
) {
    private val ADMIN: String = "ADMIN"

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf().disable()
                .httpBasic().disable()
                .formLogin().disable()
                .logout().disable()

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        http.addFilterBefore(JwtTokenFilter(jwtProvider),
                UsernamePasswordAuthenticationFilter::class.java)

        http.cors().and()
                .authorizeRequests()
                .requestMatchers("/post/**").hasRole(ADMIN)
                .anyRequest().permitAll()

        http.exceptionHandling().authenticationEntryPoint(
                HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))

        return http.build()
    }
}