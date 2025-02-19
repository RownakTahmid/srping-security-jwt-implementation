package com.theta.vorthos.service;

import com.theta.vorthos.dto.ArticleDto;
import com.theta.vorthos.dto.ArticleInfoDto;
import com.theta.vorthos.model.Article;
import jakarta.annotation.Nullable;

import java.util.List;

public interface ArticleService {
    boolean addArticle(ArticleDto article);
    List<ArticleInfoDto> getAllArticles();
    List<ArticleInfoDto> getArticlesByAuthor(@Nullable String author);
}
