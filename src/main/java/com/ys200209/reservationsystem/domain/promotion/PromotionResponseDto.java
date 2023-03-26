package com.ys200209.reservationsystem.domain.promotion;

import com.ys200209.reservationsystem.domain.category.CategoryResponseDto;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;

@Builder
@Getter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@EqualsAndHashCode
public class PromotionResponseDto {
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
}
