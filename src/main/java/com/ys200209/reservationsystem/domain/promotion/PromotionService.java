package com.ys200209.reservationsystem.domain.promotion;

import com.ys200209.reservationsystem.domain.promotion.controller.dto.PromotionsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PromotionService {
    private final PromotionRepository repository;

    public PromotionsResponseDto getPromotions() {
        return repository.getPromotions();
    }
}
