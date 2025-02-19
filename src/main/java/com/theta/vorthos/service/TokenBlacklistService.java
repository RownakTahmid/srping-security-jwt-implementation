package com.theta.vorthos.service;

import com.theta.vorthos.model.BlacklistedTokens;
import com.theta.vorthos.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenBlacklistService {
    private final TokenRepository tokenRepository;
    public boolean blacklistToken(String token) {
        try{
            tokenRepository.save(BlacklistedTokens
                    .builder()
                    .token(token)
                    .build());
            return true;
        }
        catch(Exception e){
             return false;

        }
    }
    public boolean checkTokenBlacklist(String token) {
        if (tokenRepository.existsByToken(token)) {
            return true;
        }
        return false;
    }
}
