package com.ys200209.reservationsystem.domain.repository;

import com.ys200209.reservationsystem.domain.category.controller.dto.CategoriesResponseDto;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfosRequestDto;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfosResponseDto;
import com.ys200209.reservationsystem.domain.promotion.controller.dto.PromotionsResponseDto;

public interface ReservationRepository {
    CategoriesResponseDto getCategories();

    DisplayInfosResponseDto getDisplayInfos(DisplayInfosRequestDto requestDto);

    PromotionsResponseDto getPromotions();
}
