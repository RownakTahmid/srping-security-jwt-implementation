package com.theta.vorthos.controller;

import com.theta.vorthos.dto.ArticleInfoDto;
import com.theta.vorthos.dto.UserInfoDto;
import com.theta.vorthos.service.ArticleService;
import com.theta.vorthos.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vorthos/admin")
public class AdminController {
    private final ArticleService articleService;
    private final UserInfoService userInfoService;

    @GetMapping("/all-articles")
    public List<ArticleInfoDto> getArticles() {
        return articleService.getAllArticles();
    }
    @GetMapping("/all-users")
    public List<UserInfoDto> getAllUsers() {
        return userInfoService.getUsers();
    }
}
