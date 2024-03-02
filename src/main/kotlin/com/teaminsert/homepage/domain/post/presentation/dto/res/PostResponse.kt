package com.teaminsert.homepage.domain.post.presentation.dto.res

import com.teaminsert.homepage.domain.post.domain.Post

class PostResponse(
        post: Post,
        val links: List<LinkResponse>
) {
    val category = post.category
    val title = post.title
    val nickname = post.user.nickname
    val createdAt = post.createdAt
    val contents = post.contents
}