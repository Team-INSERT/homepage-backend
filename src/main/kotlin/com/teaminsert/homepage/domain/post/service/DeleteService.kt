package com.teaminsert.homepage.domain.post.service

import com.teaminsert.homepage.domain.post.domain.repository.PostRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeleteService(
        private val postRepository: PostRepository
) {
    @Transactional
    fun execute(id: Long) {
        postRepository.deleteById(id)
    }
}