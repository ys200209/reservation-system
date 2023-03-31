package com.ys200209.reservationsystem.domain.display;

import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfosRequestDto;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfosResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DisplayInfoService {
    private final DisplayInfoRepository repository;

    public DisplayInfosResponseDto getDisplayInfos(DisplayInfosRequestDto requestDto) {
        return repository.getDisplayInfos(requestDto);
    }
}
