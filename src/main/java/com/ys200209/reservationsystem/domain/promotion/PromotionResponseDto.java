package com.ys200209.reservationsystem.domain.promotion;

import com.ys200209.reservationsystem.domain.category.CategoryResponseDto;
import com.ys200209.reservationsystem.utils.restdocs.RestDocsDto;
import com.ys200209.reservationsystem.utils.restdocs.RestDocsTemplate;
import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;

@Builder
@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class PromotionResponseDto implements RestDocsTemplate {
    private final int id;
    private final int productId;
    private final int categoryId;
    private final String categoryName;
    private final String description;
    private final int fileId;

    public static final RowMapper<PromotionResponseDto> promotionMapper = (rs, rowNum) -> {
        int id = rs.getInt("id");
        int productId = rs.getInt("productId");
        int categoryId = rs.getInt("categoryId");
        String categoryName = rs.getString("categoryName");
        String description = rs.getString("description");
        int fileId = rs.getInt("fileId");

        return new PromotionResponseDto(id, productId, categoryId, categoryName, description, fileId);
    };

    @Override
    public List<RestDocsDto> generateRestDocsFields(String rootField) {
        return List.of(
                RestDocsDto.builder().path(rootField + ".id").description("프로모션 상품 PK").build(),
                RestDocsDto.builder().path(rootField + ".productId").description("프로모션 상품 ID").build(),
                RestDocsDto.builder().path(rootField + ".categoryId").description("프로모션 상품 카테고리 ID").build(),
                RestDocsDto.builder().path(rootField + ".categoryName").description("프로모션 상품 카테고리명").build(),
                RestDocsDto.builder().path(rootField + ".description").description("프로모션 상품 설명").build(),
                RestDocsDto.builder().path(rootField + ".fileId").description("file_info 테이블의 id (product_image의 타입중 ma인 경우만)").build());
    }

    @Override
    public boolean isPathParameters() {
        return false;
    }
}
