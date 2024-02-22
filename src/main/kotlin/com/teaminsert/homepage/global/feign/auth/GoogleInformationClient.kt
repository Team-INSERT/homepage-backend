package com.teaminsert.homepage.global.feign.auth

import com.teaminsert.homepage.global.feign.auth.dto.res.GoogleInformationResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "GoogleInformationClient", url = "https://www.googleapis.com/oauth2/v1/userinfo")
interface GoogleInformationClient {
    @GetMapping("?alt=json&access_token={TOKEN}")
    fun getInformation(@PathVariable("TOKEN") accessToken: String): GoogleInformationResponse
}