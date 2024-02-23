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
        var email: String,
        var nickname: String,
        var authority: Authority,

        @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        val posts: List<Post>
) {
    @Column(name = "user_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L
}