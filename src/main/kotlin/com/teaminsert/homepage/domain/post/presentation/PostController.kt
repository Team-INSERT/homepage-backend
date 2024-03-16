package com.teaminsert.homepage.domain.post.presentation

import com.teaminsert.homepage.domain.post.presentation.dto.req.PostRequest
import com.teaminsert.homepage.domain.post.service.*
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@Tag(name = "post API")
@RequestMapping("/post")
@RestController
class PostController(
        private val listService: ListService,
        private val postService: PostService,
        private val saveService: SaveService,
        private val uploadService: UploadService,
        private val updateService: UpdateService,
        private val deleteService: DeleteService
) {
    @Operation(summary = "게시글 리스트 조회")
    @GetMapping
    fun list(category: String, pageable: Pageable)
        = listService.execute(category, pageable)

    @Operation(summary = "세부 게시글 조회")
    @GetMapping("/id")
    fun post(id: Long)
        = postService.execute(id)

    @Operation(summary = "게시글 등록")
    @PostMapping
    fun save(@RequestBody postRequest: PostRequest)
        = saveService.execute(postRequest)

    @Operation(summary = "파일 링크로 변환")
    @PostMapping("/file")
    fun file(@RequestPart file: MultipartFile)
        = uploadService.execute(file)
    @Operation(summary = "게시글 수정")
    @PutMapping
    fun update(@RequestBody postRequest: PostRequest)
        = updateService.execute(postRequest)

    @Operation(summary = "게시글 삭제")
    @DeleteMapping
    fun delete(id: Long)
        = deleteService.execute(id)
}