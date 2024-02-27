package com.teaminsert.homepage.domain.post.service

import com.teaminsert.homepage.domain.post.domain.repository.PostRepository
import com.teaminsert.homepage.domain.post.exception.PostNotFoundException
import com.teaminsert.homepage.domain.user.exception.UserNotMatchException
import com.teaminsert.homepage.domain.user.facade.UserFacade
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeleteService(
        private val userFacade: UserFacade,
        private val postRepository: PostRepository
) {
    @Transactional
    fun execute(id: Long) {
        val user = userFacade.getCurrentUser()
        val post = postRepository.findByIdOrNull(id)
                ?: throw PostNotFoundException.EXCEPTION

        if (user != post.user)
            throw UserNotMatchException.EXCEPTION

        postRepository.deleteById(id)
    }
}