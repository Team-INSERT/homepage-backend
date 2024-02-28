package com.teaminsert.homepage.global.config.error.exception

abstract class BusinessException(
        val errorCode: ErrorCode
): RuntimeException()