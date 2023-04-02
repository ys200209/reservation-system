package com.ys200209.reservationsystem.domain.product;

import com.ys200209.reservationsystem.utils.restdocs.RestDocsDto;
import com.ys200209.reservationsystem.utils.restdocs.RestDocsTemplate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class ProductPrice implements RestDocsTemplate {
    private final int id;
    private final int productId;
    private final String priceTypeName;
    private final int price;
    private final int discountRate;
    private final LocalDateTime createDate;
    private final LocalDateTime modifyDate;

    @Override
    public List<RestDocsDto> generateRestDocsFields(String rootField) {
        return List.of(
                RestDocsDto.builder().path(rootField + ".id").description("상품 가격 아이디").build(),
                RestDocsDto.builder().path(rootField + ".productId").description("상품 아이디").build(),
                RestDocsDto.builder().path(rootField + ".priceTypeName").description("상품 가격 타입명").build(),
                RestDocsDto.builder().path(rootField + ".price").description("상품 가격").build(),
                RestDocsDto.builder().path(rootField + ".discountRate").description("상품 가격 할인률").build(),
                RestDocsDto.builder().path(rootField + ".createDate").description("상품 가격 생성일").build(),
                RestDocsDto.builder().path(rootField + ".modifyDate").description("상품 가격 수정일").build());
    }

    @Override
    public boolean isPathParameters() {
        return false;
    }
}
