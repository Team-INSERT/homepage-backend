package com.teaminsert.homepage.global.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("cloud.aws")
class S3Properties(
        val s3: S3,
        val credentials: Credentials
) {
    fun getAccessKey()
        = credentials.accessKey

    fun getSecretKey()
        = credentials.secretKey

    fun getBucket()
        = s3.bucket

    class S3(
            val bucket: String
    )

    class Credentials(
            val accessKey: String,
            val secretKey: String
    )
}