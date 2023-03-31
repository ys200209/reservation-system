package com.ys200209.reservationsystem.domain.category;

import static org.assertj.core.api.Assertions.assertThat;

import com.ys200209.reservationsystem.domain.category.controller.dto.CategoryResponseDto;
import org.junit.jupiter.api.Test;

class CategoryResponseDtoTest {
    @Test
    void testCreate() {
        // given
        int testId = 10;
        String testName = "테스트 이름";
        int testCount = 10;

        CategoryResponseDto dto1 = CategoryResponseDto.builder()
                .id(testId)
                .name(testName)
                .count(testCount)
                .build();

        CategoryResponseDto dto2 = new CategoryResponseDto(testId, testName, testCount);

        // then
        assertThat(dto1).isEqualTo(dto2);
    }
}
