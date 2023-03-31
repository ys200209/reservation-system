package com.ys200209.reservationsystem.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ys200209.reservationsystem.domain.service.ReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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
}
