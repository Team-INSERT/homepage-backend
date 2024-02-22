package com.teaminsert.homepage.domain.user.exception

import com.teaminsert.homepage.global.config.error.exception.BusinessException
import com.teaminsert.homepage.global.config.error.exception.ErrorCode

class SchoolUserNotException: BusinessException(ErrorCode.SCHOOL_USER_NOT) {
    companion object {
        val EXCEPTION: BusinessException = SchoolUserNotException()
    }
}