package com.ys200209.reservationsystem.domain.category;

import static org.assertj.core.api.Assertions.assertThat;

import com.ys200209.reservationsystem.domain.category.controller.dto.CategoriesResponseDto;
import com.ys200209.reservationsystem.domain.category.controller.dto.CategoryResponseDto;
import java.util.List;
import org.junit.jupiter.api.Test;

class CategoriesResponseDtoTest {
    @Test
    void testCreate() {
        // given
        int testSize = 5;
        List<CategoryResponseDto> testItems = List.of();

        CategoriesResponseDto dto1 = CategoriesResponseDto.builder()
                .size(testSize)
                .items(testItems)
                .build();

        CategoriesResponseDto dto2 = new CategoriesResponseDto(testSize, testItems);

        // then
        assertThat(dto1).isEqualTo(dto2);
    }
}
