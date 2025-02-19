package com.theta.vorthos.dto;

import lombok.Builder;

@Builder
public record LoginDto(
        String email,
        String password
) {
}
