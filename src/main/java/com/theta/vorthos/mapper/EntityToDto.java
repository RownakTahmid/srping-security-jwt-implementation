package com.theta.vorthos.mapper;

import com.theta.vorthos.dto.ArticleInfoDto;
import com.theta.vorthos.dto.UserInfoDto;
import com.theta.vorthos.model.Article;
import com.theta.vorthos.model.UserInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EntityToDto {
    public UserInfoDto toUserDto(UserInfo user) {
        return UserInfoDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .roles(user.getRoles())
                .build();
    }

    public List<UserInfoDto> toUserDto(List<UserInfo> users) {
        List<UserInfoDto> userDto = new ArrayList<>();
        for (UserInfo user : users) {
            userDto.add(toUserDto(user));
        }
        return userDto;
    }

    public ArticleInfoDto toArticleDto(Article article) {
        return ArticleInfoDto.builder()
                .title(article.getTitle())
                .content(article.getContent())
                .author(article.getAuthor())
                .build();
    }
    public List<ArticleInfoDto> toArticleDto(List<Article> articles) {
        List<ArticleInfoDto> articleDto = new ArrayList<>();
        for (Article article : articles) {
            articleDto.add(toArticleDto(article));
        }
        return articleDto;
    }
}
