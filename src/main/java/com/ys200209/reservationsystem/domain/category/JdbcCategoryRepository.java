package com.ys200209.reservationsystem.domain.category;

import com.ys200209.reservationsystem.domain.category.controller.dto.CategoriesResponseDto;
import com.ys200209.reservationsystem.domain.category.controller.dto.CategoryResponseDto;
import com.ys200209.reservationsystem.domain.category.utils.CategorySQLMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JdbcCategoryRepository implements CategoryRepository {
    private final JdbcTemplate jdbcTemplate;

    public CategoriesResponseDto getCategories() {
        List<CategoryResponseDto> results = jdbcTemplate.query(
                CategorySQLMapper.SELECT_CATEGORIES_QUERY,
                CategoryResponseDto.categoryMapper);
        return new CategoriesResponseDto(results.size(), results);
    }
}
