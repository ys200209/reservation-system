package com.ys200209.reservationsystem.domain.promotion;

import com.ys200209.reservationsystem.domain.promotion.controller.dto.PromotionResponseDto;
import com.ys200209.reservationsystem.domain.promotion.controller.dto.PromotionsResponseDto;
import com.ys200209.reservationsystem.utils.sql.SQLMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JdbcPromotionRepository implements PromotionRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public PromotionsResponseDto getPromotions() {
        List<PromotionResponseDto> results = jdbcTemplate.query(
                SQLMapper.SELECT_PROMOTIONS_QUERY,
                PromotionResponseDto.promotionMapper
        );
        return PromotionsResponseDto.builder().size(results.size()).items(results).build();
    }
}
