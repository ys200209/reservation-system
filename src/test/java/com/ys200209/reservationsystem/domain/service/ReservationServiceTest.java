package com.ys200209.reservationsystem.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.ys200209.reservationsystem.domain.category.JdbcCategoryRepositoryTest;
import com.ys200209.reservationsystem.domain.category.controller.dto.CategoriesResponseDto;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfoResponseDto;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfosRequestDto;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfosResponseDto;
import com.ys200209.reservationsystem.domain.promotion.PromotionsResponseDto;
import com.ys200209.reservationsystem.domain.repository.JdbcReservationRepositoryTest;
import com.ys200209.reservationsystem.domain.repository.ReservationRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ReservationServiceTest {
    private CategoriesResponseDto categories = JdbcCategoryRepositoryTest.categories;

    @Mock
    private ReservationRepository repository;

    @InjectMocks
    private ReservationService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
    void testApiDisplayInfos() {
        // given
        DisplayInfosRequestDto requestDto = DisplayInfosRequestDto.builder()
                .categoryId(3)
                .start(0)
                .build();

        // when
        when(repository.getDisplayInfos(any(DisplayInfosRequestDto.class))).thenReturn(generateDisplayInfosResponseDto());

        DisplayInfosResponseDto actual = service.getDisplayInfos(requestDto);

        // then
        assertThat(actual.getTotalCount()).isEqualTo(16); // totalCount 검증
        assertThat(actual.getProductCount()).isEqualTo(4); // productCount 검증
        assertThat(actual.getProducts().size()).isEqualTo(4); // products 개수 검증
    }
    
    @Test
    void testApiPromotions() {
        // given
        PromotionsResponseDto promotions = JdbcReservationRepositoryTest.getPromotionsResponseDto();
        
        // when
        when(repository.getPromotions()).thenReturn(promotions);
        PromotionsResponseDto actual = service.getPromotions();
        
        // then
        assertThat(actual.getSize()).isEqualTo(promotions.getSize());
        assertThat(actual.getItems().get(0)).isEqualTo(promotions.getItems().get(0));
        assertThat(actual.getItems().get(10)).isEqualTo(promotions.getItems().get(10));
    }

    public static DisplayInfosResponseDto generateDisplayInfosResponseDto() {
        return DisplayInfosResponseDto.builder()
                .totalCount(16)
                .productCount(4)
                .products(
                        List.of(
                                DisplayInfoResponseDto.builder().build(),
                                DisplayInfoResponseDto.builder().build(),
                                DisplayInfoResponseDto.builder().build(),
                                DisplayInfoResponseDto.builder().build()
                        )
                )
                .build();
    }
}
