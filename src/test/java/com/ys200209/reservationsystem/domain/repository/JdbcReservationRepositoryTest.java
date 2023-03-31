package com.ys200209.reservationsystem.domain.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.ys200209.reservationsystem.domain.category.controller.dto.CategoriesResponseDto;
import com.ys200209.reservationsystem.domain.category.controller.dto.CategoryResponseDto;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfosRequestDto;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfosResponseDto;
import com.ys200209.reservationsystem.domain.promotion.PromotionResponseDto;
import com.ys200209.reservationsystem.domain.promotion.PromotionsResponseDto;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.jdbc.core.JdbcTemplate;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class JdbcReservationRepositoryTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private ReservationRepository repository;

    @BeforeEach
    void setUp() {
        repository = new JdbcReservationRepository(jdbcTemplate);
    }

    @Test
    void testApiPromotions() {
        // when
        PromotionsResponseDto actual = repository.getPromotions();

        // then
        PromotionsResponseDto expected = getPromotionsResponseDto();
        assertThat(actual.getSize()).isEqualTo(expected.getSize());
        assertThat(actual.getItems().get(0)).isEqualTo(expected.getItems().get(0));
        assertThat(actual.getItems().get(10)).isEqualTo(expected.getItems().get(10));
    }

    public static PromotionsResponseDto getPromotionsResponseDto() {
        PromotionResponseDto promotion1 = new PromotionResponseDto(1, 1, 1, "전시", "Paper, Present:너를 위한 선물", 61);
        PromotionResponseDto promotion2 = new PromotionResponseDto();
        PromotionResponseDto promotion3 = new PromotionResponseDto();
        PromotionResponseDto promotion4 = new PromotionResponseDto();
        PromotionResponseDto promotion5 = new PromotionResponseDto();
        PromotionResponseDto promotion6 = new PromotionResponseDto();
        PromotionResponseDto promotion7 = new PromotionResponseDto();
        PromotionResponseDto promotion8 = new PromotionResponseDto();
        PromotionResponseDto promotion9 = new PromotionResponseDto();
        PromotionResponseDto promotion10 = new PromotionResponseDto();
        PromotionResponseDto promotion11 = new PromotionResponseDto(11, 44, 5, "연극", "어바웃 머니\n", 172);
        List<PromotionResponseDto> promotions = List.of(promotion1, promotion2, promotion3, promotion4, promotion5,
                promotion6, promotion7, promotion8, promotion9, promotion10, promotion11);

        return new PromotionsResponseDto(promotions.size(), promotions);
    }
}
