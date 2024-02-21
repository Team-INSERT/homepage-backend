package com.teaminsert.homepage.global.config.error.exception

open class BusinessException(
        val errorCode: ErrorCode
): RuntimeException() {}