package com.ys200209.reservationsystem.domain.display.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ys200209.reservationsystem.domain.display.DisplayInfoService;
import com.ys200209.reservationsystem.domain.display.DisplayInfoServiceTest;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfosRequestDto;
import com.ys200209.reservationsystem.domain.service.ReservationService;
import com.ys200209.reservationsystem.domain.service.ReservationServiceTest;
import com.ys200209.reservationsystem.web.controller.ReservationController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class DisplayInfoApiControllerTest {
    private ObjectMapper objectMapper = new ObjectMapper();

    @InjectMocks
    private DisplayInfoApiController controller;

    @Mock
    private DisplayInfoService service;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testApiDisplayInfos() throws Exception {
        // given
        DisplayInfosRequestDto requestDto = DisplayInfosRequestDto.builder()
                .categoryId(3)
                .start(0)
                .build();

        // when
        when(service.getDisplayInfos(any(DisplayInfosRequestDto.class))).thenReturn(DisplayInfoServiceTest.generateDisplayInfosResponseDto());

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
}
