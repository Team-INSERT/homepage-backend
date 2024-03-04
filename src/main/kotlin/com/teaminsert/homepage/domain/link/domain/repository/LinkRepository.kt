package com.teaminsert.homepage.domain.link.domain.repository

import com.teaminsert.homepage.domain.link.domain.Link
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface LinkRepository: CrudRepository<Link, Long> {
}