package com.ys200209.reservationsystem.domain.display;

import com.ys200209.reservationsystem.utils.restdocs.RestDocsDto;
import com.ys200209.reservationsystem.utils.restdocs.RestDocsTemplate;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@Builder
@Getter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class DisplayInfosResponseDto implements RestDocsTemplate {
    private final int totalCount;
    private final int productCount;
    private final List<DisplayInfoResponseDto> products;

    @Override
    public List<RestDocsDto> generateRestDocsFields(String rootField) {
        List<RestDocsDto> results = new ArrayList<>();
        generateTotalCount(results);
        generateProductCount(results);
        generateProducts(results);
        return results;
    }

    private void generateTotalCount(List<RestDocsDto> results) {
        results.add(RestDocsDto.builder().path("totalCount").description("해당 카테고리의 전시 상품 수").build());
    }

    private void generateProductCount(List<RestDocsDto> results) {
        results.add(RestDocsDto.builder().path("productCount").description("읽어온 전시 상품 수").build());
    }

    private void generateProducts(List<RestDocsDto> results) {
        results.add(RestDocsDto.builder().path("products[]").description("전시 상품 정보").build());
        results.addAll(new DisplayInfoResponseDto().generateRestDocsFields("products[]"));
    }
}
