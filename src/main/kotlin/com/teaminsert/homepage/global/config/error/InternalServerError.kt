package com.teaminsert.homepage.global.config.error

import com.teaminsert.homepage.global.config.error.exception.BusinessException
import com.teaminsert.homepage.global.config.error.exception.ErrorCode

class InternalServerError: BusinessException(ErrorCode.INTERNAL_SERVER_ERROR) {
    companion object {
        val EXCEPTION: BusinessException = InternalServerError()
    }
}