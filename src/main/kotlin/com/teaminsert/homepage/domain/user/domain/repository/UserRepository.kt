package com.teaminsert.homepage.domain.user.domain.repository

import com.teaminsert.homepage.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, Long> {
    fun findByEmail(email: String): User?
}