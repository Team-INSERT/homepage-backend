package com.teaminsert.homepage.domain.user.domain

import com.teaminsert.homepage.domain.user.domain.type.Authority
import jakarta.persistence.*

@Entity
class User(
        email: String,
        nickname: String,
        authority: Authority
) {
    @Column(name = "user_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    var email: String = email
        protected set

    var nickname: String = nickname
        protected set

    var authority: Authority = authority
        protected set
}