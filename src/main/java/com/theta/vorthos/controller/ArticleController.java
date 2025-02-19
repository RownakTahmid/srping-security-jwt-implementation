package com.theta.vorthos.controller;

import com.theta.vorthos.dto.ArticleDto;
import com.theta.vorthos.dto.ArticleInfoDto;
import com.theta.vorthos.model.Article;
import com.theta.vorthos.service.ArticleService;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vorthos/article")
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping()
    public String writeArticle(@RequestBody ArticleDto article) {
        return articleService.addArticle(article)?"Article added successfully":"Article not added";
    }
    @GetMapping("/home")
    public String welcome() {
        return "Welcome to Vorthos Articles!!!";
    }
    @GetMapping("/articles-by-author")
    public ResponseEntity<List<ArticleInfoDto>> getAllArticlesByAnAuthor(@RequestParam @Nullable String author) {
        return ResponseEntity.status(HttpStatus.OK).body(articleService.getArticlesByAuthor(author));
    }
}
