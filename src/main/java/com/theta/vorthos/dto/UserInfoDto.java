package com.theta.vorthos.dto;

import com.theta.vorthos.enums.Roles;
import lombok.Builder;

import java.util.Set;
@Builder
public record UserInfoDto(
        String name,
        String email,
        Set<Roles> roles
) {
}
