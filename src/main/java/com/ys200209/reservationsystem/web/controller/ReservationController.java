package com.ys200209.reservationsystem.web.controller;

import com.ys200209.reservationsystem.domain.detaildisplay.DetailDisplayInfosResponseDto;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfoResponseDto;
import com.ys200209.reservationsystem.domain.product.ProductPrice;
import com.ys200209.reservationsystem.domain.service.ReservationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class ReservationController {
    private final ReservationService service;

    @GetMapping("/displayinfos/{displayId}")
    public DetailDisplayInfosResponseDto getDetailDisplayInfos(@PathVariable int displayId) {
        return DetailDisplayInfosResponseDto.builder()
                .product(DisplayInfoResponseDto.builder().build())
//                .productImages(ProductImageDto.builder().build())
//                .displayInfoImages(DisplayInfoImageDto.builder().build())
                .avgScore(0)
                .productPrices(List.of(ProductPrice.builder().build()))
                .build();
    }
}
