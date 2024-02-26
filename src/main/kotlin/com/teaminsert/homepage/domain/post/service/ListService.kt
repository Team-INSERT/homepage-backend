package com.teaminsert.homepage.domain.post.service

import com.teaminsert.homepage.domain.post.domain.repository.PostRepository
import com.teaminsert.homepage.domain.post.domain.type.Category
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ListService(
        private val postRepository: PostRepository
) {
    @Transactional(readOnly = true)
    fun execute(category: String, pageable: Pageable)
        = postRepository.findByCategory(Category.valueOf(category), pageable)
}