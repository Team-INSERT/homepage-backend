package com.teaminsert.homepage.domain.post.service

import com.teaminsert.homepage.domain.link.domain.Link
import com.teaminsert.homepage.domain.post.domain.repository.PostRepository
import com.teaminsert.homepage.domain.post.presentation.dto.req.SaveRequest
import com.teaminsert.homepage.domain.user.domain.User
import com.teaminsert.homepage.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SaveService(
        private val userFacade: UserFacade,
        private val postRepository: PostRepository
) {
    @Transactional
    fun execute(saveRequest: SaveRequest): Long {
        val user: User = userFacade.getCurrentUser()
        val links = mutableListOf<Link>()
        saveRequest.links.forEach {
            links.add(Link(it.title, it.url))
        }

        val post = postRepository.save(saveRequest.toEntity(user, links))

        links.forEach {
            it.updatePost(post)
        }

        return post.id
    }
}