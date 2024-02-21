package com.teaminsert.homepage.global.config.error.exception

import org.springframework.http.HttpStatus

class ErrorResponse(
        status: HttpStatus,
        message: String
) {
    companion object {
        fun of(errorCode: ErrorCode): ErrorResponse {
            return ErrorResponse(errorCode.status, errorCode.message)
        }
    }
}