package com.ys200209.reservationsystem.domain.repository;

import com.ys200209.reservationsystem.domain.category.CategoriesResponseDto;
import com.ys200209.reservationsystem.domain.display.DisplayInfosRequestDto;
import com.ys200209.reservationsystem.domain.display.DisplayInfosResponseDto;

public interface ReservationRepository {
    CategoriesResponseDto getCategories();

    DisplayInfosResponseDto getDisplayInfos(DisplayInfosRequestDto requestDto);
}
