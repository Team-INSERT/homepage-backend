package com.teaminsert.homepage.domain.post.presentation.dto.res

import com.teaminsert.homepage.domain.link.domain.Link
import com.teaminsert.homepage.domain.post.domain.Post
import com.teaminsert.homepage.domain.post.domain.type.Category
import com.teaminsert.homepage.domain.user.domain.User

data class SaveRequest(
        val title: String,
        val contents: String,
        val category: String,
        val links: List<LinkRequest>
) {
    data class LinkRequest(
            val title: String,
            val url: String
    )

    fun toEntity(user: User, links: List<Link>) = Post(
            title = title,
            contents = contents,
            category = Category.valueOf(category),
            links = links,
            user = user
    )
}