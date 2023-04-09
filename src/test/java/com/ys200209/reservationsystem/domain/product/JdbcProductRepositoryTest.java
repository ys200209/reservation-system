package com.ys200209.reservationsystem.domain.product;

import static org.assertj.core.api.Assertions.assertThat;

import com.ys200209.reservationsystem.domain.product.dto.ProductImageDto;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.jdbc.core.JdbcTemplate;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class JdbcProductRepositoryTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private ProductRepository repository;

    @BeforeEach
    void setUp() {
        repository = new JdbcProductRepository(jdbcTemplate);
    }

    @Test
    void testProductImages() {
        // given
        List<ProductImageDto> expected = getProductImages();

        // when
        List<ProductImageDto> actual = repository.getProductImages(1);

        // then
        assertThat(actual.size()).isEqualTo(expected.size());
        assertThat(actual.get(0).getProductId()).isEqualTo(expected.get(0).getProductId());
        assertThat(actual.get(0).getProductImageId()).isEqualTo(expected.get(0).getProductImageId());
        assertThat(actual.get(0).getFileInfoId()).isEqualTo(expected.get(0).getFileInfoId());
    }

    @Test
    void testProductPrice() {
        // given
        List<ProductPrice> expected = getProductPrice();

        // when
        List<ProductPrice> actual = repository.getProductPrice(1);

        // then
        assertThat(actual.size()).isEqualTo(expected.size());
        assertThat(actual.get(0).getPrice()).isEqualTo(expected.get(0).getPrice());
        assertThat(actual.get(1).getPrice()).isEqualTo(expected.get(1).getPrice());
        assertThat(actual.get(2).getPrice()).isEqualTo(expected.get(2).getPrice());
    }

    public static List<ProductPrice> getProductPrice() {
        return List.of(
                ProductPrice.builder().price(6000).build(),
                ProductPrice.builder().price(3000).build(),
                ProductPrice.builder().price(2000).build()
        );
    }

    public static List<ProductImageDto> getProductImages() {
        return List.of(
                ProductImageDto.builder()
                        .productId(1)
                        .productImageId(2)
                        .fileInfoId(61)
                        .build()
        );
    }
}
