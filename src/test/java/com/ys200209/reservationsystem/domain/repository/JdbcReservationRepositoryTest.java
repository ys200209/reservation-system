package com.ys200209.reservationsystem.domain.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.ys200209.reservationsystem.domain.category.CategoriesResponseDto;
import com.ys200209.reservationsystem.domain.category.CategoryResponseDto;
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
public class JdbcReservationRepositoryTest {
    private static CategoryResponseDto category1 = new CategoryResponseDto(1, "전시", 10);
    private static CategoryResponseDto category2 = new CategoryResponseDto(2, "뮤지컬", 10);
    private static CategoryResponseDto category3 = new CategoryResponseDto(3, "콘서트", 16);
    private static CategoryResponseDto category4 = new CategoryResponseDto(4, "클래식", 10);
    private static CategoryResponseDto category5 = new CategoryResponseDto(5, "연극", 13);

    public static CategoriesResponseDto categories = CategoriesResponseDto.builder()
            .size(5)
            .items(List.of(category1, category2, category3, category4, category5))
            .build();

    @Autowired JdbcTemplate jdbcTemplate;

    private ReservationRepository repository;

    @BeforeEach
    void setUp() {
        repository = new JdbcReservationRepository(jdbcTemplate);
    }

    @Test
    void testApiCategories() {
        // given


        // when
        CategoriesResponseDto actual = repository.getCategories();

        // then
        assertThat(actual).isEqualTo(categories);
    }
}
