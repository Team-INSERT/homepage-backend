package com.teaminsert.homepage.domain.user.facade

import com.teaminsert.homepage.domain.user.exception.UserNotFoundException
import com.teaminsert.homepage.domain.user.domain.repository.UserRepository
import org.springframework.context.annotation.Configuration
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User

@Configuration
class UserFacade(
        private val userRepository: UserRepository
) {
    fun getCurrentUser(): User {
        val email: String = SecurityContextHolder.getContext().authentication.name
        return getUserByEmail(email)
    }

    fun getUserByEmail(email: String)
        = userRepository.findByEmail(email) ?: throw UserNotFoundException.EXCEPTION
}