package com.ys200209.reservationsystem.domain.repository;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ys200209.reservationsystem.domain.category.CategoriesResponseDto;
import com.ys200209.reservationsystem.domain.category.CategoryResponseDto;
import com.ys200209.reservationsystem.domain.display.DisplayInfoResponseDto;
import com.ys200209.reservationsystem.domain.display.DisplayInfosRequestDto;
import com.ys200209.reservationsystem.domain.display.DisplayInfosResponseDto;
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
    public static CategoriesResponseDto categories = getCategoriesResponseDto();

    @Autowired
    JdbcTemplate jdbcTemplate;

    private ReservationRepository repository;

    @BeforeEach
    void setUp() {
        repository = new JdbcReservationRepository(jdbcTemplate);
    }

    @Test
    void testApiCategories() {
        // when
        CategoriesResponseDto actual = repository.getCategories();

        // then
        assertThat(actual).isEqualTo(categories);
    }

    @ParameterizedTest
    @MethodSource("generateDisplayInfosRequestDto")
    void testApiDisplayInfos(DisplayInfosRequestDto requestDto, int expectedSize) {
        // when
        DisplayInfosResponseDto actual = repository.getDisplayInfos(requestDto);

        // then
//        assertThat(actual).isEqualTo(displayInfos); 모든 필드를 가지고 있지 않기 때문에 이런 간단한 방식으로는 검증할 수 없음.
        assertThat(actual.getTotalCount()).isEqualTo(16); // totalCount 검증
        assertThat(actual.getProductCount()).isEqualTo(4); // productCount 검증
        assertThat(actual.getProducts().size()).isEqualTo(expectedSize); // products 개수 검증
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

    public static Stream<Arguments> generateDisplayInfosRequestDto() {
        return Stream.of(
                Arguments.of(DisplayInfosRequestDto.builder().categoryId(3).start(0).build(), 4),
                Arguments.of(DisplayInfosRequestDto.builder().categoryId(3).start(14).build(), 2)
        );
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
