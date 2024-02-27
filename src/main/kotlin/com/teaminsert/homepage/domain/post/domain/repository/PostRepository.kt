package com.teaminsert.homepage.domain.post.domain.repository

import com.teaminsert.homepage.domain.post.domain.Post
import com.teaminsert.homepage.domain.post.domain.type.Category
import com.teaminsert.homepage.domain.post.presentation.dto.res.ListPostResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface PostRepository: JpaRepository<Post, Long> {
    @Query("SELECT " +
            "new com.teaminsert.homepage.domain.post.presentation.dto.res.ListPostResponse(" +
            "p.id, p.title, p.user, p.createdAt) " +
            "FROM Post p " +
            "WHERE p.category = :category " +
            "ORDER BY p.id DESC")
    fun findByCategory(@Param("category") category: Category, pageable: Pageable): Page<ListPostResponse>
}