package com.teaminsert.homepage.global.config.error

import com.fasterxml.jackson.databind.ObjectMapper
import com.teaminsert.homepage.global.config.error.exception.BusinessException
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException

class GlobalExceptionFilter(
        private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {
    override fun doFilterInternal(
            request: HttpServletRequest,
            response: HttpServletResponse,
            filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: BusinessException) {
            val errorCode = e.errorCode
            val errorResponse = ErrorResponse(errorCode.status, errorCode.message)
            writeErrorResponse(response, errorCode.status, errorResponse)
        }
    }

    @Throws(IOException::class)
    private fun writeErrorResponse(
            response: HttpServletResponse,
            status: Int,
            errorResponse:
            ErrorResponse
    ) {
        response.status = status
        response.contentType = "application/json"
        response.characterEncoding = "UTF-8"
        objectMapper.writeValue(response.writer, errorResponse)
    }
}
