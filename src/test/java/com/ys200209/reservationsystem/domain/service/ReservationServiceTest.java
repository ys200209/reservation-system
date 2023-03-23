package com.ys200209.reservationsystem.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.ys200209.reservationsystem.domain.category.CategoriesResponseDto;
import com.ys200209.reservationsystem.domain.display.DisplayInfoResponseDto;
import com.ys200209.reservationsystem.domain.display.DisplayInfosRequestDto;
import com.ys200209.reservationsystem.domain.display.DisplayInfosResponseDto;
import com.ys200209.reservationsystem.domain.repository.JdbcReservationRepositoryTest;
import com.ys200209.reservationsystem.domain.repository.ReservationRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ReservationServiceTest {
    private CategoriesResponseDto categories = JdbcReservationRepositoryTest.categories;

    @Mock
    private ReservationRepository repository;

    @InjectMocks
    private ReservationService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testApiCategories() {
        // when
        when(repository.getCategories()).thenReturn(categories);

        CategoriesResponseDto actual = service.getCategories();

        // then
        assertThat(actual).isEqualTo(categories);
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
