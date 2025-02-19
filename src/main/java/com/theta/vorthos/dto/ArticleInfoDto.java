package com.theta.vorthos.dto;

import lombok.Builder;

@Builder
public record ArticleInfoDto(
        String title,
        String author,
        String content
) {
}
