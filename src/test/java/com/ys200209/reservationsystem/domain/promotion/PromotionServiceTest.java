package com.ys200209.reservationsystem.domain.promotion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.ys200209.reservationsystem.domain.promotion.controller.dto.PromotionsResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class PromotionServiceTest {
    @Mock
    private PromotionRepository repository;

    @InjectMocks
    private PromotionService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testApiPromotions() {
        // given
        PromotionsResponseDto promotions = JdbcPromotionRepositoryTest.getPromotionsResponseDto();

        // when
        when(repository.getPromotions()).thenReturn(promotions);
        PromotionsResponseDto actual = service.getPromotions();

        // then
        assertThat(actual.getSize()).isEqualTo(promotions.getSize());
        assertThat(actual.getItems().get(0)).isEqualTo(promotions.getItems().get(0));
        assertThat(actual.getItems().get(10)).isEqualTo(promotions.getItems().get(10));
    }
}
