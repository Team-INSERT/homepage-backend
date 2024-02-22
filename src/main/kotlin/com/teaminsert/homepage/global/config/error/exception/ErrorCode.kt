package com.teaminsert.homepage.global.config.error.exception

import org.springframework.http.HttpStatus

enum class ErrorCode(
        val status: HttpStatus,
        val message: String
) {
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User Not Found"),
    EXPIRED_JWT(HttpStatus.UNAUTHORIZED, "Expired Jwt"),

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "인터널 서버 에러");
}