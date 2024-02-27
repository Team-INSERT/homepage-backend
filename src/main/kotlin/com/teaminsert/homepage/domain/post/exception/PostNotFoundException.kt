package com.teaminsert.homepage.domain.post.exception

import com.teaminsert.homepage.global.config.error.exception.BusinessException
import com.teaminsert.homepage.global.config.error.exception.ErrorCode

class PostNotFoundException: BusinessException(ErrorCode.POST_NOT_FOUND) {
    companion object {
        val EXCEPTION: BusinessException = PostNotFoundException()
    }
}