package com.teaminsert.homepage.global.config.error

import com.teaminsert.homepage.global.config.error.exception.BusinessException
import com.teaminsert.homepage.global.config.error.exception.ErrorCode
import com.teaminsert.homepage.global.config.error.exception.ErrorResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(e: BusinessException): ResponseEntity<ErrorResponse> {
        val errorCode: ErrorCode = e.errorCode
        val response: ErrorResponse = ErrorResponse.of(errorCode)
        return ResponseEntity(response, errorCode.status)
    }
}