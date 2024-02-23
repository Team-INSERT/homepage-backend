package com.teaminsert.homepage.domain.file.domain

import com.teaminsert.homepage.domain.post.domain.Post
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class File(
        val title: String,
        val file: String,

        @ManyToOne
        @JoinColumn(name = "post_id")
        val post: Post
) {
    @Column(name = "file_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L
}