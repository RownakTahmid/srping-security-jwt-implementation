package com.theta.vorthos.dto;

import com.theta.vorthos.enums.Roles;
import lombok.Builder;

import java.util.Set;
@Builder
public record UserDto(
        String name,
        String email,
        String password,
        Set<Roles> roles
) {
}
