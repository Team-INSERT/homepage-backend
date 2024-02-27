package com.teaminsert.homepage.domain.post.presentation.dto.res

import com.teaminsert.homepage.domain.user.domain.User
import java.time.LocalDateTime

class ListPostResponse(
        val id: Long,
        val title: String,
        val thumbnail: String?,
        user: User,
        val createdDate: LocalDateTime
) {
    val user = user.nickname
}