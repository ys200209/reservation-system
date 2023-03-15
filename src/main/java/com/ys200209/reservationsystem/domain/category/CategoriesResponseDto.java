package com.ys200209.reservationsystem.domain.category;

import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Builder
@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class CategoriesResponseDto {
    private final int size;
    private final List<CategoryResponseDto> items;
}
