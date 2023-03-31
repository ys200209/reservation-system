package com.ys200209.reservationsystem.domain.category;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.ys200209.reservationsystem.domain.category.controller.dto.CategoriesResponseDto;
import com.ys200209.reservationsystem.domain.category.controller.dto.CategoryResponseDto;
import com.ys200209.reservationsystem.domain.repository.JdbcReservationRepository;
import com.ys200209.reservationsystem.domain.repository.ReservationRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.jdbc.core.JdbcTemplate;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class JdbcCategoryRepositoryTest {
    public static CategoriesResponseDto categories = getCategoriesResponseDto();

    @Autowired
    JdbcTemplate jdbcTemplate;

    private CategoryRepository repository;

    @BeforeEach
    void setUp() {
        repository = new JdbcCategoryRepository(jdbcTemplate);
    }

    @Test
    void testApiCategories() {
        // when
        CategoriesResponseDto actual = repository.getCategories();

        // then
        assertThat(actual).isEqualTo(categories);
    }

    private static CategoriesResponseDto getCategoriesResponseDto() {
        CategoryResponseDto category1 = new CategoryResponseDto(1, "전시", 10);
        CategoryResponseDto category2 = new CategoryResponseDto(2, "뮤지컬", 10);
        CategoryResponseDto category3 = new CategoryResponseDto(3, "콘서트", 16);
        CategoryResponseDto category4 = new CategoryResponseDto(4, "클래식", 10);
        CategoryResponseDto category5 = new CategoryResponseDto(5, "연극", 13);

        return CategoriesResponseDto.builder()
                .size(5)
                .items(List.of(category1, category2, category3, category4, category5))
                .build();
    }
}
