package com.teaminsert.homepage.domain.user.exception

import com.teaminsert.homepage.global.config.error.exception.BusinessException
import com.teaminsert.homepage.global.config.error.exception.ErrorCode

object UserNotMatchException: BusinessException(ErrorCode.USER_NOT_MATCH)