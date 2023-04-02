package com.ys200209.reservationsystem.domain.category.utils;

public class CategorySQLMapper {
    public static final String SELECT_CATEGORIES_QUERY = "SELECT category.id as id, name, count(category_id) as count from category, product, display_info where category.id = product.category_id and product.id = display_info.product_id group by category_id;";
}
