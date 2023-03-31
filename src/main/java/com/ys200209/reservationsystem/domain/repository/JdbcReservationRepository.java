package com.ys200209.reservationsystem.domain.repository;

import com.ys200209.reservationsystem.domain.category.controller.dto.CategoriesResponseDto;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfosRequestDto;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfosResponseDto;
import com.ys200209.reservationsystem.domain.promotion.controller.dto.PromotionsResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class JdbcReservationRepository implements ReservationRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public CategoriesResponseDto getCategories() {
        return null;
    }

    @Override
    public DisplayInfosResponseDto getDisplayInfos(DisplayInfosRequestDto requestDto) {
        return null;
    }

    @Override
    public PromotionsResponseDto getPromotions() {
        return null;
    }
}
