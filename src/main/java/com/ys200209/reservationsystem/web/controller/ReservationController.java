package com.ys200209.reservationsystem.web.controller;

import com.ys200209.reservationsystem.domain.category.CategoriesResponseDto;
import com.ys200209.reservationsystem.domain.category.CategoryResponseDto;
import com.ys200209.reservationsystem.domain.service.ReservationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService service;

    @GetMapping("/api/categories")
    public CategoriesResponseDto getCategories() {
        return service.getCategories();
    }
}
