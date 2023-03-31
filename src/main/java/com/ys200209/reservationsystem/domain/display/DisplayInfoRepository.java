package com.ys200209.reservationsystem.domain.display;

import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfosRequestDto;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfosResponseDto;

public interface DisplayInfoRepository {
    DisplayInfosResponseDto getDisplayInfos(DisplayInfosRequestDto requestDto);
}
