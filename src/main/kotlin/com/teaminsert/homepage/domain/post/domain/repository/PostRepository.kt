package com.teaminsert.homepage.domain.post.domain.repository

import com.teaminsert.homepage.domain.post.domain.Post
import com.teaminsert.homepage.domain.post.domain.type.Category
import com.teaminsert.homepage.domain.post.presentation.dto.res.ListPostResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface PostRepository: CrudRepository<Post, Long> {
    @Query("SELECT " +
            "new com.teaminsert.homepage.domain.post.presentation.dto.res.ListPostResponse(" +
            "p.id, p.title, LEFT(p.contents, 50), p.thumbnail, p.user, CASE WHEN p.user.email = :email THEN true ELSE false END, p.createdAt) " +
            "FROM Post p " +
            "WHERE p.category = :category " +
            "ORDER BY p.id")
    fun findByCategory(@Param("email") user: String?, @Param("category") category: Category, pageable: Pageable): Page<ListPostResponse>

    @Query("SELECT p FROM Post p JOIN FETCH p.links l JOIN FETCH p.user u WHERE p.id = :id")
    fun findByIdJoin(@Param("id") id: Long): Post?
}
