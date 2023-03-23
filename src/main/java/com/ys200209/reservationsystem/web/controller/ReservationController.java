package com.ys200209.reservationsystem.web.controller;

import com.ys200209.reservationsystem.domain.category.CategoriesResponseDto;
import com.ys200209.reservationsystem.domain.display.DisplayInfoResponseDto;
import com.ys200209.reservationsystem.domain.display.DisplayInfosRequestDto;
import com.ys200209.reservationsystem.domain.display.DisplayInfosResponseDto;
import com.ys200209.reservationsystem.domain.promotion.PromotionResponseDto;
import com.ys200209.reservationsystem.domain.promotion.PromotionsResponseDto;
import com.ys200209.reservationsystem.domain.service.ReservationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class ReservationController {
    private final ReservationService service;

    @GetMapping("/categories")
    public CategoriesResponseDto getCategories() {
        CategoriesResponseDto categories = service.getCategories();
        log.info("getCategories(): {}", categories);
        return categories;
    }

    @GetMapping("/displayinfos")
    public DisplayInfosResponseDto getDisplayInfos(@RequestBody DisplayInfosRequestDto requestDto) {
        DisplayInfosResponseDto displayInfos = service.getDisplayInfos(requestDto);
        log.info("getDisplayInfos(): {}", displayInfos  );
        return displayInfos;
    }

    @GetMapping("/promotions")
    public PromotionsResponseDto getPromotions() {
        return PromotionsResponseDto.builder()
                .items(
                        List.of(
                                PromotionResponseDto.builder().build()
                        )
                )
                .build();
    }
}
