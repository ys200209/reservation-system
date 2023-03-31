package com.ys200209.reservationsystem.domain.service;

import com.ys200209.reservationsystem.domain.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository repository;
}
