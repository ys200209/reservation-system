package com.ys200209.reservationsystem.domain.product;

import com.ys200209.reservationsystem.domain.product.dto.ProductImageDto;
import com.ys200209.reservationsystem.domain.product.utils.ProductSQLMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JdbcProductRepository implements ProductRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<ProductImageDto> getProductImages(int displayId) {
        return jdbcTemplate.query(ProductSQLMapper.SELECT_PRODUCT_IMAGES,
                ProductImageDto.productImageMapper,
                displayId);
    }

    @Override
    public List<ProductPrice> getProductPrice(int displayId) {
        return jdbcTemplate.query(
                ProductSQLMapper.SELECT_PRODUCT_PRICES,
                ProductPrice.productPriceMapper,
                displayId
        );
    }
}
