package com.teaminsert.homepage.domain.post.facade

import com.teaminsert.homepage.domain.post.domain.repository.PostRepository
import com.teaminsert.homepage.domain.post.exception.PostNotFoundException
import org.springframework.context.annotation.Configuration
import org.springframework.data.repository.findByIdOrNull

@Configuration
class PostFacade(
        private val postRepository: PostRepository
) {
    fun getPost(id: Long)
        = postRepository.findByIdOrNull(id)
            ?: throw PostNotFoundException
}