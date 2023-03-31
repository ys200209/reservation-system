package com.ys200209.reservationsystem.domain.promotion.controller.dto;

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
public class PromotionsResponseDto implements RestDocsTemplate {
    private final int size;
    private final List<PromotionResponseDto> items;

    @Override
    public List<RestDocsDto> generateRestDocsFields(String rootField) {
        List<RestDocsDto> results = new ArrayList<>();
        generateSize(results);
        generateItems(results);
        return results;
    }

    private void generateSize(List<RestDocsDto> results) {
        results.add(RestDocsDto.builder().path("size").description("프로모션 정보의 수").build());
    }

    private void generateItems(List<RestDocsDto> results) {
        results.add(RestDocsDto.builder().path("items[]").description("프로모션 상품 정보").build());
        results.addAll(new PromotionResponseDto().generateRestDocsFields("items[]"));
    }
}
