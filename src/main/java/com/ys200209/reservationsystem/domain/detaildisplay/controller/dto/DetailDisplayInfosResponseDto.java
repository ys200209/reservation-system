package com.ys200209.reservationsystem.domain.detaildisplay.controller.dto;

import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfoImageDto;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfoResponseDto;
import com.ys200209.reservationsystem.domain.product.ProductPrice;
import com.ys200209.reservationsystem.domain.product.dto.ProductImageDto;
import com.ys200209.reservationsystem.utils.restdocs.RestDocsDto;
import com.ys200209.reservationsystem.utils.restdocs.RestDocsTemplate;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class DetailDisplayInfosResponseDto implements RestDocsTemplate {
    private final DisplayInfoResponseDto product;
    private final List<ProductImageDto> productImages;
    private final List<DisplayInfoImageDto> displayInfoImages;
    private final int avgScore;
    private final List<ProductPrice> productPrices;

    @Override
    public List<RestDocsDto> generateRestDocsFields(String rootField) {
        List<RestDocsDto> results = new ArrayList<>();
        generateProduct(results);
        generateProductImages(results);
        generateDisplayInfoImages(results);
        generateAvgScore(results);
        generateProductPrices(results);
        return results;
    }

    private void generateProductImages(List<RestDocsDto> results) {
        results.add(RestDocsDto.builder().path("productImages[]").description("상품 이미지 정보들").build());
        results.addAll(new ProductImageDto().generateRestDocsFields("productImages[]"));
    }

    private void generateDisplayInfoImages(List<RestDocsDto> results) {
        results.add(RestDocsDto.builder().path("displayInfoImages[]").description("전시 이미지 정보들").build());
        results.addAll(new DisplayInfoImageDto().generateRestDocsFields("displayInfoImages[]"));
    }

    private void generateAvgScore(List<RestDocsDto> results) {
        results.add(RestDocsDto.builder().path("avgScore").description("평점").build());
    }

    private void generateProductPrices(List<RestDocsDto> results) {
        results.add(RestDocsDto.builder().path("productPrices[]").description("상품 가격 정보들").build());
        results.addAll(new ProductPrice().generateRestDocsFields("productPrices[]"));
    }

    private void generateProduct(List<RestDocsDto> results) {
        results.add(RestDocsDto.builder().path("product").description("전시 상품 정보").build());
        results.addAll(new DisplayInfoResponseDto().generateRestDocsFields("product"));
    }

    @Override
    public boolean isPathParameters() {
        return false;
    }
}
