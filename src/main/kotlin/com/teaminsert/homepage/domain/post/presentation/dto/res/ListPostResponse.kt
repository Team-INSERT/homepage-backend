package com.teaminsert.homepage.domain.post.presentation.dto.res

import com.teaminsert.homepage.domain.user.domain.User
import java.time.LocalDateTime

class ListPostResponse(
        val id: Long,
        val title: String,
        val contents: String,
        val thumbnail: String?,
        user: User,
        val isAuthor: Boolean,
        val createdDate: LocalDateTime
) {
    val nickname = user.nickname
}