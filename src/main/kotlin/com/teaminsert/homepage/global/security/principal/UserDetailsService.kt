package com.teaminsert.homepage.global.security.principal

import com.teaminsert.homepage.domain.user.facade.UserFacade
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsService(
        private val userFacade: UserFacade
): UserDetailsService {
    override fun loadUserByUsername(email: String)
        = AuthDetails(userFacade.getUserByEmail(email))
}