package com.teaminsert.homepage.global.config.error

import com.teaminsert.homepage.global.config.error.exception.BusinessException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(e: BusinessException): ResponseEntity<String> {
        val code = e.errorCode
        return ResponseEntity(code.message, code.status)
    }
}