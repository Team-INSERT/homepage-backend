package com.teaminsert.homepage.domain.user.exception

import com.teaminsert.homepage.global.config.error.exception.BusinessException
import com.teaminsert.homepage.global.config.error.exception.ErrorCode

class UserNotFoundException: BusinessException(ErrorCode.USER_NOT_FOUND) {
    companion object {
        val EXCEPTION: BusinessException = UserNotFoundException()
    }
}