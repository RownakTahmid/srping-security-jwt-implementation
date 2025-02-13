package com.theta.vorthos.repository;

import com.theta.vorthos.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
