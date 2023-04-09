package com.ys200209.reservationsystem.domain.product;

import com.ys200209.reservationsystem.domain.product.dto.ProductImageDto;
import java.util.List;

public interface ProductRepository {
    List<ProductImageDto> getProductImages(int displayId);

    List<ProductPrice> getProductPrice(int displayId);
}
