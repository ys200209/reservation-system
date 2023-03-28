package com.ys200209.reservationsystem.domain.category;

import com.ys200209.reservationsystem.utils.restdocs.RestDocsDto;
import com.ys200209.reservationsystem.utils.restdocs.RestDocsTemplate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.jdbc.core.RowMapper;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class CategoryResponseDto implements RestDocsTemplate {
    private final int id;
    private final String name;
    private final int count;

    public static final RowMapper<CategoryResponseDto> categoryMapper = (rs, rowNum) -> {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        int count = rs.getInt("count");
        return new CategoryResponseDto(id, name, count);
    };

    @Override
    public List<RestDocsDto> generateRestDocsFields(String rootField) {
        return List.of(
                RestDocsDto.builder().path(rootField + ".id").description("카테고리 id").build(),
                RestDocsDto.builder().path(rootField + ".name").description("카테고리 이름").build(),
                RestDocsDto.builder().path(rootField + ".count").description("카테고리에 포함된 전시 상품(display_info)의 수").build()
        );
    }
}
