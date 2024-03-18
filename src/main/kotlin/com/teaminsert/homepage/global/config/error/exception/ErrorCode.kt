package com.teaminsert.homepage.global.config.error.exception

import org.springframework.http.HttpStatus

enum class ErrorCode(
        val status: Int,
        val message: String
) {
    USER_NOT_MATCH(400, "User Not Match"),
    SCHOOL_USER_NOT(400, "School User Not"),
    EXPIRED_JWT(401, "Expired Jwt"),
    INVALID_JWT(401, "Invalid Jwt"),
    USER_NOT_FOUND(404, "User Not Found"),
    POST_NOT_FOUND(404, "Post Not Found"),
}