package com.ys200209.reservationsystem.domain.category;

import com.ys200209.reservationsystem.domain.category.controller.dto.CategoriesResponseDto;

public interface CategoryRepository {
    CategoriesResponseDto getCategories();
}
