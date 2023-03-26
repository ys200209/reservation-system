package com.ys200209.reservationsystem.domain.promotion;

import com.ys200209.reservationsystem.utils.restdocs.RestDocsDto;
import com.ys200209.reservationsystem.utils.restdocs.RestDocsTemplate;
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
    public List<RestDocsDto> generateRestDocsFields() {
        return List.of(
                RestDocsDto.builder().path("size").description("프로모션 정보의 수").build(),
                RestDocsDto.builder().path("items[]").description("프로모션 상품 정보").build(),
                RestDocsDto.builder().path("items[].id").description("프로모션 상품 PK").build(),
                RestDocsDto.builder().path("items[].productId").description("프로모션 상품 ID").build(),
                RestDocsDto.builder().path("items[].categoryId").description("프로모션 상품 카테고리 ID").build(),
                RestDocsDto.builder().path("items[].categoryName").description("프로모션 상품 카테고리명").build(),
                RestDocsDto.builder().path("items[].description").description("프로모션 상품 설명").build(),
                RestDocsDto.builder().path("items[].fileId").description("file_info 테이블의 id (product_image의 타입중 ma인 경우만)").build()
        );
    }
}
