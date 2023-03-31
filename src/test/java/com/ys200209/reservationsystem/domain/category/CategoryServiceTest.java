package com.ys200209.reservationsystem.domain.category;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.ys200209.reservationsystem.domain.category.controller.dto.CategoriesResponseDto;
import com.ys200209.reservationsystem.domain.repository.JdbcReservationRepositoryTest;
import com.ys200209.reservationsystem.domain.repository.ReservationRepository;
import com.ys200209.reservationsystem.domain.service.ReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CategoryServiceTest {
    private CategoriesResponseDto categories = JdbcCategoryRepositoryTest.categories;

    @Mock
    private JdbcCategoryRepository repository;

    @InjectMocks
    private CategoryService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testApiCategories() {
        // when
        when(repository.getCategories()).thenReturn(categories);

        CategoriesResponseDto actual = service.getCategories();

        // then
        assertThat(actual).isEqualTo(categories);
    }
}