package com.ys200209.reservationsystem.domain.category;

import com.ys200209.reservationsystem.utils.restdocs.RestDocsDto;
import com.ys200209.reservationsystem.utils.restdocs.RestDocsTemplate;
import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class CategoryResponseDto {
    private final int id;
    private final String name;
    private final int count;
}
