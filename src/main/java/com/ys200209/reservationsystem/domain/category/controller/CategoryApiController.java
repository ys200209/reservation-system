package com.ys200209.reservationsystem.domain.category.controller;

import com.ys200209.reservationsystem.domain.category.CategoryService;
import com.ys200209.reservationsystem.domain.category.controller.dto.CategoriesResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CategoryApiController {
    private final CategoryService service;

    @GetMapping("/categories")
    public CategoriesResponseDto getCategories() {
        return service.getCategories();
    }
}
