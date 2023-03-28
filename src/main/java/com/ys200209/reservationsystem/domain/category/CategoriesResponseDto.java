package com.ys200209.reservationsystem.domain.category;

import com.ys200209.reservationsystem.utils.restdocs.RestDocsDto;
import com.ys200209.reservationsystem.utils.restdocs.RestDocsTemplate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
    public List<RestDocsDto> generateRestDocsFields(String rootField) {
        List<RestDocsDto> results = new ArrayList<>();
        generateSize(results);
        generateItems(results);
        return results;
    }

    private void generateSize(List<RestDocsDto> results) {
        results.add(RestDocsDto.builder().path("size").description("카테고리 개수").build());
    }

    private void generateItems(List<RestDocsDto> results) {
        results.add(RestDocsDto.builder().path("items[]").description("카테고리 정보").build());
        results.addAll(new CategoryResponseDto().generateRestDocsFields("items[]"));
    }
}
