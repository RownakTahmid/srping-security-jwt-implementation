package com.theta.vorthos.service;

import com.theta.vorthos.dto.ArticleDto;
import com.theta.vorthos.dto.ArticleInfoDto;
import com.theta.vorthos.mapper.DtoToEntity;
import com.theta.vorthos.mapper.EntityToDto;
import com.theta.vorthos.model.Article;
import com.theta.vorthos.repository.ArticleRepository;
import com.theta.vorthos.repository.UserInfoRepository;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final DtoToEntity dtoToEntity;
    private final EntityToDto entityToDto;
    private final UserInfoRepository userInfoRepository;

    @Override
    public boolean addArticle(ArticleDto article) {
        try {
            articleRepository.save(dtoToEntity.toArticle(article));
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<ArticleInfoDto> getAllArticles() {
        return entityToDto.toArticleDto(articleRepository.findAll());
    }

    @Override
    public List<ArticleInfoDto> getArticlesByAuthor(@Nullable String writer) {
        if(writer != null) {
             return entityToDto.toArticleDto(articleRepository.findByAuthor(writer));
        }
        String author = Objects.requireNonNull(userInfoRepository.findByEmail(
                SecurityContextHolder.getContext().getAuthentication().getName()).orElse(null)).getName();
        return entityToDto.toArticleDto(articleRepository.findByAuthor(author));
    }
}
