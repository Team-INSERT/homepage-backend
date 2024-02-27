package com.teaminsert.homepage.domain.post.service

import com.teaminsert.homepage.infra.s3.service.S3Service
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class UploadService(
        private val s3Service: S3Service
) {
    fun execute(file: MultipartFile)
        = s3Service.uploadFile(file)
}