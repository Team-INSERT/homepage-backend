package com.teaminsert.homepage.global.security.principal

import com.teaminsert.homepage.domain.user.domain.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.Collections

class AuthDetails(
        private val user: User
): UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority?> {
        return listOf<SimpleGrantedAuthority>(SimpleGrantedAuthority("ROLE_" + user.authority))
    }

    override fun getPassword(): String? {
        return null
    }

    override fun getUsername(): String {
        return user.email
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}