package com.teaminsert.homepage.global.security.jwt.exception

import com.teaminsert.homepage.global.config.error.exception.BusinessException
import com.teaminsert.homepage.global.config.error.exception.ErrorCode

object InvalidJwtException: BusinessException(ErrorCode.INVALID_JWT)