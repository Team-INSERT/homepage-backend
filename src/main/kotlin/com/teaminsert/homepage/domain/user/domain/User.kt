package com.teaminsert.homepage.domain.user.domain

import com.teaminsert.homepage.domain.post.domain.Post
import com.teaminsert.homepage.domain.user.domain.type.Authority
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

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

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var posts: List<Post>? = null
        protected set
}