package com.ys200209.reservationsystem.domain.promotion.controller;

import com.ys200209.reservationsystem.domain.promotion.PromotionService;
import com.ys200209.reservationsystem.domain.promotion.controller.dto.PromotionsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PromotionApiController {
    private final PromotionService service;

    @GetMapping("/promotions")
    public PromotionsResponseDto getPromotions() {
        return service.getPromotions();
    }
}
