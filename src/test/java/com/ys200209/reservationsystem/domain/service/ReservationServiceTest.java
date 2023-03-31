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
    @Mock
    private ReservationRepository repository;

    @InjectMocks
    private ReservationService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
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
}
