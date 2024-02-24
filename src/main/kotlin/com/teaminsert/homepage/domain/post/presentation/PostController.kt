package com.teaminsert.homepage.domain.post.presentation

import com.teaminsert.homepage.domain.post.presentation.dto.res.SaveRequest
import com.teaminsert.homepage.domain.post.service.SaveService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/post")
@RestController
class PostController(
        private val saveService: SaveService
) {
    @PostMapping
    fun save(@RequestBody saveRequest: SaveRequest)
        = saveService.execute(saveRequest)
}