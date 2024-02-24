package com.teaminsert.homepage.domain.post.domain

import com.teaminsert.homepage.domain.link.domain.Link
import com.teaminsert.homepage.domain.post.domain.type.Category
import com.teaminsert.homepage.domain.user.domain.User
import com.teaminsert.homepage.global.entity.BaseTimeEntity
import jakarta.persistence.*

@Entity
class Post(
        title: String,
        contents: String,
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

    @Enumerated(value = EnumType.STRING)
    var category: Category = category
        protected set

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User = user
        protected set

    @OneToMany(mappedBy = "post", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var links :List<Link> = links
        protected set
}