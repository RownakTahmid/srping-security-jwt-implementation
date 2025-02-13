package com.theta.vorthos.mapper;

import com.theta.vorthos.dto.UserDto;
import com.theta.vorthos.model.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
@RequiredArgsConstructor
public class DtoToEntity {
    private final PasswordEncoder passwordEncoder;
    public UserInfo toUserInfo(UserDto userDto) {
        return UserInfo.builder()
                .name(userDto.name())
                .email(userDto.email())
                .password(passwordEncoder.encode(userDto.password()))
                .roles(userDto.roles())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
