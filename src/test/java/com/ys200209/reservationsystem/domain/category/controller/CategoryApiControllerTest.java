package com.ys200209.reservationsystem.domain.category.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ys200209.reservationsystem.domain.category.CategoryService;
import com.ys200209.reservationsystem.domain.category.JdbcCategoryRepositoryTest;
import com.ys200209.reservationsystem.domain.repository.JdbcReservationRepositoryTest;
import com.ys200209.reservationsystem.domain.service.ReservationService;
import com.ys200209.reservationsystem.web.controller.ReservationController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class CategoryApiControllerTest {
    private ObjectMapper objectMapper = new ObjectMapper();

    @InjectMocks
    private CategoryApiController controller;

    @Mock
    private CategoryService service;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testApiCategories() throws Exception {
        // when
        when(service.getCategories()).thenReturn(JdbcCategoryRepositoryTest.categories);

        // then
        mockMvc.perform(get("/api/categories"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size").exists())
                .andExpect(jsonPath("$.items").isArray())
                .andExpect(jsonPath("$.items[0].id").value(1))
                .andExpect(jsonPath("$.items[0].name").value("전시"))
                .andExpect(jsonPath("$.items[0].count").value(10))
                .andExpect(jsonPath("$.items[4].id").value(5))
                .andExpect(jsonPath("$.items[4].name").value("연극"))
                .andExpect(jsonPath("$.items[4].count").value(13));
    }
}
