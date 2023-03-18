package com.ys200209.reservationsystem.utils.restdocs;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class RestDocsDto {
    private final String path;
    private final String description;
}
