package com.ys200209.reservationsystem.domain.service;

import com.ys200209.reservationsystem.domain.category.CategoriesResponseDto;
import com.ys200209.reservationsystem.domain.display.DisplayInfosRequestDto;
import com.ys200209.reservationsystem.domain.display.DisplayInfosResponseDto;
import com.ys200209.reservationsystem.domain.promotion.PromotionsResponseDto;
import com.ys200209.reservationsystem.domain.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository repository;

    public CategoriesResponseDto getCategories() {
        return repository.getCategories();
    }

    public DisplayInfosResponseDto getDisplayInfos(DisplayInfosRequestDto requestDto) {
        return repository.getDisplayInfos(requestDto);
    }

    public PromotionsResponseDto getPromotions() {
        return repository.getPromotions();
    }
}
