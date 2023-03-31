package com.ys200209.reservationsystem.domain.promotion;

import com.ys200209.reservationsystem.domain.promotion.controller.dto.PromotionsResponseDto;

public interface PromotionRepository {
    PromotionsResponseDto getPromotions();
}
