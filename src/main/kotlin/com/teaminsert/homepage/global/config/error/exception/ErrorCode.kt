package com.teaminsert.homepage.global.config.error.exception

import org.springframework.http.HttpStatus

enum class ErrorCode(
        val status: HttpStatus,
        val message: String
) {
    USER_NOT_MATCH(HttpStatus.BAD_REQUEST, "User Not Match"),
    SCHOOL_USER_NOT(HttpStatus.BAD_REQUEST, "School User Not"),
    EXPIRED_JWT(HttpStatus.BAD_REQUEST, "Expired Jwt"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User Not Found"),
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "Post Not Found"),
}