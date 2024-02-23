package com.teaminsert.homepage.domain.file.repository

import com.teaminsert.homepage.domain.file.domain.File
import org.springframework.data.jpa.repository.JpaRepository

interface FileRepository: JpaRepository<File, Long> {
}