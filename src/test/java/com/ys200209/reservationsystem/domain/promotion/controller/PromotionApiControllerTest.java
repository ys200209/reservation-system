package com.ys200209.reservationsystem.domain.promotion.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ys200209.reservationsystem.domain.promotion.JdbcPromotionRepositoryTest;
import com.ys200209.reservationsystem.domain.promotion.PromotionService;
import com.ys200209.reservationsystem.domain.promotion.controller.dto.PromotionsResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class PromotionApiControllerTest {
    private ObjectMapper objectMapper = new ObjectMapper();

    @InjectMocks
    private PromotionApiController controller;

    @Mock
    private PromotionService service;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testApiPromotions() throws Exception {
        // given
        PromotionsResponseDto expected = JdbcPromotionRepositoryTest.getPromotionsResponseDto();

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
