package com.teaminsert.homepage.domain.post.domain

import com.teaminsert.homepage.domain.file.domain.File
import com.teaminsert.homepage.domain.post.domain.type.Category
import com.teaminsert.homepage.domain.user.domain.User
import com.teaminsert.homepage.global.entity.BaseTimeEntity
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany

@Entity
class Post(
        val title: String,

        val contents: String,

        @Enumerated(value = EnumType.STRING)
        val category: Category,

        @ManyToOne
        @JoinColumn(name = "user_id")
        val user: User,

        @OneToMany(mappedBy = "post", cascade = [CascadeType.ALL], orphanRemoval = true)
        val files :List<File>
):BaseTimeEntity() {
    @Column(name = "post_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L
}