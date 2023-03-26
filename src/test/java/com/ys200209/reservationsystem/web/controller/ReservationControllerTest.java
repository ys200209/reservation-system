package com.ys200209.reservationsystem.web.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ys200209.reservationsystem.domain.display.DisplayInfosRequestDto;
import com.ys200209.reservationsystem.domain.promotion.PromotionsResponseDto;
import com.ys200209.reservationsystem.domain.repository.JdbcReservationRepositoryTest;
import com.ys200209.reservationsystem.domain.service.ReservationService;
import com.ys200209.reservationsystem.domain.service.ReservationServiceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class ReservationControllerTest {
    private ObjectMapper objectMapper = new ObjectMapper();

    @InjectMocks
    private ReservationController controller;

    @Mock
    private ReservationService service;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testApiCategories() throws Exception {
        // when
        when(service.getCategories()).thenReturn(JdbcReservationRepositoryTest.categories);

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

    @Test
    void testApiDisplayInfos() throws Exception {
        // given
        DisplayInfosRequestDto requestDto = DisplayInfosRequestDto.builder()
                .categoryId(3)
                .start(0)
                .build();

        // when
        when(service.getDisplayInfos(any(DisplayInfosRequestDto.class))).thenReturn(ReservationServiceTest.generateDisplayInfosResponseDto());

        // then
        mockMvc.perform(get("/api/displayinfos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalCount").value(16))
                .andExpect(jsonPath("$.productCount").value(4))
                .andExpect(jsonPath("$.products").isArray())
                .andExpect(jsonPath("$.products", hasSize(4)));
    }

    @Test
    void testApiPromotions() throws Exception {
        // given
        PromotionsResponseDto expected = JdbcReservationRepositoryTest.getPromotionsResponseDto();

        // when
        when(service.getPromotions()).thenReturn(expected);

        // then
        mockMvc.perform(get("/api/promotions"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size").value(11))
                .andExpect(jsonPath("$.items").isArray())
                .andExpect(jsonPath("$.items[0].fileId").value(61))
                .andExpect(jsonPath("$.items[10].fileId").value(172));
    }
}
