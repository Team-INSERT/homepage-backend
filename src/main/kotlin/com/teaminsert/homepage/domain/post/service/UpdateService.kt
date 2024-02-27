package com.teaminsert.homepage.domain.post.service

import com.teaminsert.homepage.domain.link.domain.repository.LinkRepository
import com.teaminsert.homepage.domain.post.facade.PostFacade
import com.teaminsert.homepage.domain.post.presentation.dto.req.PostRequest
import com.teaminsert.homepage.domain.user.exception.UserNotMatchException
import com.teaminsert.homepage.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdateService(
        private val userFacade: UserFacade,
        private val linkRepository: LinkRepository,
        private val postFacade: PostFacade,
) {
    @Transactional
    fun execute(postRequest: PostRequest) {
        val post = postFacade.getPost(postRequest.id)

        if (userFacade.getCurrentUser() != post.user)
            throw UserNotMatchException.EXCEPTION

        linkRepository.deleteAll(post.links)

        post.updatePost(postRequest)

        post.links.forEach { it.updatePost(post) }
    }
}