package com.ys200209.reservationsystem.domain.repository;

import com.ys200209.reservationsystem.domain.category.controller.dto.CategoriesResponseDto;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfoResponseDto;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfosRequestDto;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfosResponseDto;
import com.ys200209.reservationsystem.domain.promotion.PromotionResponseDto;
import com.ys200209.reservationsystem.domain.promotion.PromotionsResponseDto;
import com.ys200209.reservationsystem.utils.sql.SQLMapper;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class JdbcReservationRepository implements ReservationRepository {
    private static final int SHOW_PRODUCT_COUNT_AMOUNT = 4;

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
        List<PromotionResponseDto> results = jdbcTemplate.query(
                SQLMapper.SELECT_PROMOTIONS_QUERY,
                PromotionResponseDto.promotionMapper
        );
        return PromotionsResponseDto.builder().size(results.size()).items(results).build();
    }
}



















