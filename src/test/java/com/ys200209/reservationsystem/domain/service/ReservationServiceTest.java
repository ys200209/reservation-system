package com.ys200209.reservationsystem.domain.service;

import com.ys200209.reservationsystem.domain.repository.ReservationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ReservationServiceTest {
    @Mock
    private ReservationRepository repository;

    @InjectMocks
    private ReservationService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
}
