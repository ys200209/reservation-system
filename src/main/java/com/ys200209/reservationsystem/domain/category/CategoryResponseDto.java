package com.ys200209.reservationsystem.domain.category;

import com.ys200209.reservationsystem.utils.restdocs.RestDocsDto;
import com.ys200209.reservationsystem.utils.restdocs.RestDocsTemplate;
import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.jdbc.core.RowMapper;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@RequiredArgsConstructor
public class CategoryResponseDto {
    private final int id;
    private final String name;
    private final int count;

    public static final RowMapper<CategoryResponseDto> categoryMapper = (rs, rowNum) -> {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        int count = rs.getInt("count");
        return new CategoryResponseDto(id, name, count);
    };
}
