package com.teaminsert.homepage.domain.post.presentation.dto.req

import com.teaminsert.homepage.domain.link.domain.Link
import com.teaminsert.homepage.domain.post.domain.Post
import com.teaminsert.homepage.domain.post.domain.type.Category
import com.teaminsert.homepage.domain.user.domain.User

data class PostRequest(
        val id: Long,
        val title: String,
        val contents: String,
        val thumbnail: String?,
        val category: String,
        val links: List<LinkRequest>
) {
    data class LinkRequest(
            val title: String,
            val url: String
    )

    fun toLinks(): List<Link> {
        val links = mutableListOf<Link>()
        this.links.forEach {
            links.add(Link(it.title, it.url))
        }
        return links
    }

    fun toEntity(user: User, links: List<Link>) = Post(
            title = title,
            contents = contents,
            thumbnail = thumbnail,
            category = Category.valueOf(category),
            links = links,
            user = user
    )
}