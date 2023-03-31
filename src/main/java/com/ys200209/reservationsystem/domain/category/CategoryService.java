package com.ys200209.reservationsystem.domain.category;

import com.ys200209.reservationsystem.domain.category.controller.dto.CategoriesResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;

    public CategoriesResponseDto getCategories() {
        return repository.getCategories();
    }
}
