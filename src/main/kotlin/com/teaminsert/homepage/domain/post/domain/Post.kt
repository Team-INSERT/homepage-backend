package com.teaminsert.homepage.domain.post.domain

import com.teaminsert.homepage.domain.link.domain.Link
import com.teaminsert.homepage.domain.post.domain.type.Category
import com.teaminsert.homepage.domain.post.presentation.dto.req.PostRequest
import com.teaminsert.homepage.domain.user.domain.User
import com.teaminsert.homepage.global.entity.BaseTimeEntity
import jakarta.persistence.*

@Entity
class Post(
        title: String,
        contents: String,
        thumbnail: String?,
        category: Category,
        links: List<Link>,
        user: User,

):BaseTimeEntity() {
    @Column(name = "post_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    var title: String = title
        protected set

    var contents: String = contents
        protected set

    var thumbnail: String? = thumbnail
        protected set

    @Enumerated(value = EnumType.STRING)
    var category: Category = category
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User = user
        protected set

    @OneToMany(mappedBy = "post", cascade = [CascadeType.ALL])
    var links :List<Link> = links
        protected set

    fun updatePost(postRequest: PostRequest) {
        this.title = postRequest.title
        this.contents = postRequest.contents
        this.thumbnail = postRequest.thumbnail
        this.category = Category.valueOf(postRequest.category)
        this.links = postRequest.toLinks()
    }
}