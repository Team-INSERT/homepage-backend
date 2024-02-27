package com.teaminsert.homepage.global.config

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.teaminsert.homepage.global.config.properties.S3Properties
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class S3Config(
        @Value("\${cloud.aws.region.static}")
        val region: String,
        val s3Properties: S3Properties
) {
    @Bean
    fun amazonS3Client(): AmazonS3Client {
        val awsCredentials
            = BasicAWSCredentials(s3Properties.getAccessKey(), s3Properties.getSecretKey())
        return AmazonS3ClientBuilder.standard()
                .withRegion(region)
                .withCredentials(AWSStaticCredentialsProvider(awsCredentials))
                .build() as AmazonS3Client
    }
}