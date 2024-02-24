package com.teaminsert.homepage.domain.link.domain.repository

import com.teaminsert.homepage.domain.link.domain.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository: JpaRepository<Link, Long> {
}