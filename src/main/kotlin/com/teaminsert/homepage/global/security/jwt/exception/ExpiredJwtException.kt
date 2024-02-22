package com.teaminsert.homepage.global.security.jwt.exception

import com.teaminsert.homepage.global.config.error.exception.BusinessException
import com.teaminsert.homepage.global.config.error.exception.ErrorCode

class ExpiredJwtException: BusinessException(ErrorCode.EXPIRED_JWT) {
    companion object {
        val EXCEPTION: BusinessException = ExpiredJwtException()
    }
}