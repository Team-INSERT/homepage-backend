package com.teaminsert.homepage.domain.post.presentation

import com.teaminsert.homepage.domain.post.presentation.dto.req.PostRequest
import com.teaminsert.homepage.domain.post.service.ListService
import com.teaminsert.homepage.domain.post.service.SaveService
import com.teaminsert.homepage.domain.post.service.UpdateService
import com.teaminsert.homepage.domain.post.service.UploadService
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RequestMapping("/post")
@RestController
class PostController(
        private val listService: ListService,
        private val saveService: SaveService,
        private val uploadService: UploadService,
        private val updateService: UpdateService
) {
    @GetMapping
    fun list(category: String, @PageableDefault(page = 0, size = 10) pageable: Pageable)
        = listService.execute(category, pageable)

    @PostMapping
    fun save(@RequestBody postRequest: PostRequest)
        = saveService.execute(postRequest)

    @PostMapping("/file")
    fun file(@RequestPart file: MultipartFile)
        = uploadService.execute(file)

    @PutMapping
    fun update(@RequestBody postRequest: PostRequest)
        = updateService.execute(postRequest)
}