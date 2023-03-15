package com.ys200209.reservationsystem.domain.repository;

import com.ys200209.reservationsystem.domain.category.CategoriesResponseDto;

public interface ReservationRepository {
    CategoriesResponseDto
    getCategories();
}
