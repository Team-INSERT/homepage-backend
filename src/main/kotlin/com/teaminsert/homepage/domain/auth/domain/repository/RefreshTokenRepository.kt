package com.teaminsert.homepage.domain.auth.domain.repository

import com.teaminsert.homepage.domain.auth.domain.RefreshToken
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository: CrudRepository<RefreshToken, String> {
}