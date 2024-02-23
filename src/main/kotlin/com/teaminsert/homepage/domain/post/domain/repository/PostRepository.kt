package com.teaminsert.homepage.domain.post.domain.repository

import com.teaminsert.homepage.domain.post.domain.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository: JpaRepository<Post, Long> {
}