package com.ys200209.reservationsystem.domain.display.controller;

import com.ys200209.reservationsystem.domain.display.DisplayInfoService;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfosRequestDto;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfosResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DisplayInfoApiController {
    private final DisplayInfoService service;

    @GetMapping("/displayinfos")
    public DisplayInfosResponseDto getDisplayInfos(@RequestBody DisplayInfosRequestDto requestDto) {
        return service.getDisplayInfos(requestDto);
    }
}
