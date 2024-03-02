package com.teaminsert.homepage.domain.post.service

import com.teaminsert.homepage.domain.post.domain.repository.PostRepository
import com.teaminsert.homepage.domain.post.exception.PostNotFoundException
import com.teaminsert.homepage.domain.post.presentation.dto.res.LinkResponse
import com.teaminsert.homepage.domain.post.presentation.dto.res.PostResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostService(
        private val postRepository: PostRepository
) {
    @Transactional(readOnly = true)
    fun execute(id: Long): PostResponse {
        val post = postRepository.findByIdJoin(id)
                ?: throw PostNotFoundException
        val links = mutableListOf<LinkResponse>()

        post.links.forEach{
            links.add(LinkResponse(it.title, it.url))
        }

        return PostResponse(post, links)
    }
}