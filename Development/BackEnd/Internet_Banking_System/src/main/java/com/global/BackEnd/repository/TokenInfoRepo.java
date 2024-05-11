package com.global.BackEnd.repository;

import com.global.BackEnd.Entity.TokenInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenInfoRepo extends JpaRepository<TokenInfo, Long> {
    Optional<TokenInfo> findByRefreshToken (String refreshToken);
    Optional<TokenInfo> findByAccessToken (String accessToken);
}
