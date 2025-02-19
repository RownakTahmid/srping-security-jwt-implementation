package com.theta.vorthos.dto;

import lombok.Builder;

@Builder
public record ArticleDto(
         String title,
         String content
) {
}
