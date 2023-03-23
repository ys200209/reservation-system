package com.ys200209.reservationsystem.domain.category;

import com.ys200209.reservationsystem.utils.restdocs.RestDocsDto;
import com.ys200209.reservationsystem.utils.restdocs.RestDocsTemplate;
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
@EqualsAndHashCode
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class CategoriesResponseDto implements RestDocsTemplate {
    private final int size;
    private final List<CategoryResponseDto> items;

    @Override
    public List<RestDocsDto> generateRestDocsFields() {
        return List.of(
                RestDocsDto.builder().path("size").description("카테고리 개수").build(),
                RestDocsDto.builder().path("items[]").description("카테고리 정보").build(),
                RestDocsDto.builder().path("items[].id").description("카테고리 id").build(),
                RestDocsDto.builder().path("items[].name").description("카테고리 이름").build(),
                RestDocsDto.builder().path("items[].count").description("카테고리에 포함된 전시 상품(display_info)의 수").build()
        );
    }
}
