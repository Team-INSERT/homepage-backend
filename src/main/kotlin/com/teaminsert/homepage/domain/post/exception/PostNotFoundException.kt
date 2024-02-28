package com.teaminsert.homepage.domain.post.exception

import com.teaminsert.homepage.global.config.error.exception.BusinessException
import com.teaminsert.homepage.global.config.error.exception.ErrorCode

object PostNotFoundException: BusinessException(ErrorCode.POST_NOT_FOUND)