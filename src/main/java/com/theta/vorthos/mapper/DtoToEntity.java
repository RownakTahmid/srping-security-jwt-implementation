package com.theta.vorthos.mapper;

import com.theta.vorthos.dto.ArticleDto;
import com.theta.vorthos.dto.UserDto;
import com.theta.vorthos.model.Article;
import com.theta.vorthos.model.UserInfo;
import com.theta.vorthos.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class DtoToEntity {
    private final PasswordEncoder passwordEncoder;
    private final UserInfoRepository userInfoRepository;
    public UserInfo toUserInfo(UserDto userDto) {
        return UserInfo.builder()
                .name(userDto.name())
                .email(userDto.email())
                .password(passwordEncoder.encode(userDto.password()))
                .roles(userDto.roles())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public Article toArticle(ArticleDto articleDto) {
        String author = Objects.requireNonNull(userInfoRepository.findByEmail(
                SecurityContextHolder.getContext().getAuthentication().getName()).orElse(null)).getName();
        return Article.builder()
                .title(articleDto.title())
                .author(author)
                .content(articleDto.content())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
