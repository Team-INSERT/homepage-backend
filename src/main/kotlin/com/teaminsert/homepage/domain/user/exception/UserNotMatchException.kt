package com.teaminsert.homepage.domain.user.exception

import com.teaminsert.homepage.global.config.error.exception.BusinessException
import com.teaminsert.homepage.global.config.error.exception.ErrorCode

class UserNotMatchException: BusinessException(ErrorCode.USER_NOT_MATCH) {
    companion object {
        val EXCEPTION: BusinessException = UserNotMatchException()
    }
}