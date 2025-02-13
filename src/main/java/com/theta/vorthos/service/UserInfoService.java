package com.theta.vorthos.service;

import com.theta.vorthos.dto.LoginDto;
import com.theta.vorthos.dto.UserDto;
import com.theta.vorthos.model.UserInfo;
import org.springframework.stereotype.Component;

@Component
public interface UserInfoService {
    boolean signup(UserDto userDto);
    boolean login(LoginDto loginDto);
}
