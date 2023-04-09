package com.ys200209.reservationsystem.domain.display;

import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfoImageDto;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfoResponseDto;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfosRequestDto;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfosResponseDto;
import java.util.List;

public interface DisplayInfoRepository {
    DisplayInfoResponseDto getDisplayInfo(int displayId);

    DisplayInfosResponseDto getDisplayInfos(DisplayInfosRequestDto requestDto);

    List<DisplayInfoImageDto> getDisplayInfoImages(int displayId);
}
