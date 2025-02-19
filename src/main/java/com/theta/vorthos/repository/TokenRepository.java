package com.theta.vorthos.repository;

import com.theta.vorthos.model.BlacklistedTokens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository  extends JpaRepository<BlacklistedTokens, Long> {
    boolean existsByToken(String token);
}
