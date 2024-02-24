package com.teaminsert.homepage.domain.link.domain

import com.teaminsert.homepage.domain.post.domain.Post
import jakarta.persistence.*

@Entity
class Link(
        title: String,
        url: String
) {
    @Column(name = "link_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    var title: String = title
        protected set

    var url: String = url
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    var post: Post? = null
        protected set

    fun updatePost(post: Post) {
        this.post = post
    }
}