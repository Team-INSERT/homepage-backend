package com.teaminsert.homepage.domain.user.domain.repository

import com.teaminsert.homepage.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
}