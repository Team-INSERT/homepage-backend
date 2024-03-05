package com.teaminsert.homepage.domain.post.service

import com.teaminsert.homepage.domain.post.domain.repository.PostRepository
import com.teaminsert.homepage.domain.post.domain.type.Category
import com.teaminsert.homepage.domain.user.domain.User
import com.teaminsert.homepage.domain.user.facade.UserFacade
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ListService(
        private val userFacade: UserFacade,
        private val postRepository: PostRepository
) {
    @Transactional(readOnly = true)
    fun execute(category: String, pageable: Pageable) {
        var user = ""
        if (userFacade.isLogin())
            user = userFacade.getCurrentUser().email
        postRepository.findByCategory(user, Category.valueOf(category), pageable)

    }
}