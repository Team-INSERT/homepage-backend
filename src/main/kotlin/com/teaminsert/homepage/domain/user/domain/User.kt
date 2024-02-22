package com.teaminsert.homepage.domain.user.domain

import com.teaminsert.homepage.domain.user.domain.type.Authority
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class User(
        var email: String,
        var nickname: String,
        var authority: Authority
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L
}