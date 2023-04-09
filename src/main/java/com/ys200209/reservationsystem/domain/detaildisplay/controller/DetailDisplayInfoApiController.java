package com.ys200209.reservationsystem.domain.detaildisplay.controller;

import com.ys200209.reservationsystem.domain.detaildisplay.controller.dto.DetailDisplayInfosResponseDto;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfoImageDto;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfoResponseDto;
import com.ys200209.reservationsystem.domain.product.ProductPrice;
import com.ys200209.reservationsystem.domain.product.dto.ProductImageDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DetailDisplayInfoApiController {
    @GetMapping("/displayinfos/{displayId}")
    public DetailDisplayInfosResponseDto getDetailDisplayInfos(@PathVariable int displayId) {
        return DetailDisplayInfosResponseDto.builder()
                .product(DisplayInfoResponseDto.builder().build())
                .productImages(List.of(ProductImageDto.builder().build()))
                .displayInfoImages(List.of(DisplayInfoImageDto.builder().build()))
                .avgScore(0)
                .productPrices(List.of(ProductPrice.builder().build()))
                .build();
    }
}
