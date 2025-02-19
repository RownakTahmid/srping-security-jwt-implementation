package com.theta.vorthos.service;

import com.theta.vorthos.dto.LoginDto;
import com.theta.vorthos.dto.UserDto;
import com.theta.vorthos.dto.UserInfoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserInfoService {
    boolean signup(UserDto userDto);
    ResponseEntity<String> login(LoginDto loginDto);
    boolean logout(String AuthorizationHeader);
    List<UserInfoDto> getUsers();
    boolean writeArticle(String article);
    boolean editArticle(String article);
}
