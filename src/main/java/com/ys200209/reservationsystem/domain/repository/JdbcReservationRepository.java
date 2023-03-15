package com.ys200209.reservationsystem.domain.repository;

import com.ys200209.reservationsystem.domain.category.CategoriesResponseDto;
import com.ys200209.reservationsystem.domain.category.CategoryResponseDto;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JdbcReservationRepository implements ReservationRepository {
    private static final String SELECT_CATEGORIES_QUERY = "SELECT category.id as id, name, count(category_id) as count from category, product, display_info where category.id = product.category_id and product.id = display_info.product_id group by category_id;";

    private final JdbcTemplate jdbcTemplate;

    public CategoriesResponseDto getCategories() {
        System.out.println("jdbcTemplate = " + jdbcTemplate);
        List<CategoryResponseDto> results = jdbcTemplate.query(
                SELECT_CATEGORIES_QUERY,
                categoryMapper);
        return new CategoriesResponseDto(results.size(), results);
    }

    private static final RowMapper<CategoryResponseDto> categoryMapper = (rs, rowNum) -> {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        int count = rs.getInt("count");
        return new CategoryResponseDto(id, name, count);
    };
}
