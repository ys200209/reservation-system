package com.ys200209.reservationsystem.domain.detaildisplay;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.ys200209.reservationsystem.domain.comment.CommentResponseDto;
import com.ys200209.reservationsystem.domain.comment.JdbcCommentRepository;
import com.ys200209.reservationsystem.domain.comment.JdbcCommentRepositoryTest;
import com.ys200209.reservationsystem.domain.detaildisplay.controller.dto.DetailDisplayInfosRequestDto;
import com.ys200209.reservationsystem.domain.detaildisplay.controller.dto.DetailDisplayInfosResponseDto;
import com.ys200209.reservationsystem.domain.display.JdbcDisplayInfoRepository;
import com.ys200209.reservationsystem.domain.display.JdbcDisplayInfoRepositoryTest;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfoImageDto;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfoResponseDto;
import com.ys200209.reservationsystem.domain.product.JdbcProductRepository;
import com.ys200209.reservationsystem.domain.product.JdbcProductRepositoryTest;
import com.ys200209.reservationsystem.domain.product.ProductPrice;
import com.ys200209.reservationsystem.domain.product.dto.ProductImageDto;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class DetailDisplayInfoServiceTest {
    @InjectMocks
    private DetailDisplayInfoService service;

    @Mock private JdbcDisplayInfoRepository displayInfoRepository;
    @Mock private JdbcProductRepository productRepository;
    @Mock private JdbcCommentRepository commentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDetailDisplayInfos() {
        // given
        DisplayInfoResponseDto expectedDisplayInfo = JdbcDisplayInfoRepositoryTest.getDisplayInfo();
        List<ProductImageDto> expectedProductImages = JdbcProductRepositoryTest.getProductImages();
        List<DisplayInfoImageDto> expectedDisplayInfoImages = JdbcDisplayInfoRepositoryTest.getDisplayInfoImages();
        CommentResponseDto expectedComment = JdbcCommentRepositoryTest.getCommentsScoreByProductId();
        List<ProductPrice> expectedProductPrices = JdbcProductRepositoryTest.getProductPrice();
        DetailDisplayInfosResponseDto expected = getDetailDisplayInfos();

        // when
        when(displayInfoRepository.getDisplayInfo(1)).thenReturn(expectedDisplayInfo);
        when(productRepository.getProductImages(1)).thenReturn(expectedProductImages);
        when(displayInfoRepository.getDisplayInfoImages(1)).thenReturn(expectedDisplayInfoImages);
        when(commentRepository.getCommentsScoreByDisplayId(1)).thenReturn(expectedComment);
        when(productRepository.getProductPrice(1)).thenReturn(expectedProductPrices);
        DetailDisplayInfosResponseDto actual = service.getDetailDisplayInfos(new DetailDisplayInfosRequestDto(1));

        // then
        assertThat(actual.getProduct().getId()).isEqualTo(expected.getProduct().getId());
        assertThat(actual.getProductImages().size()).isEqualTo(expected.getProductImages().size());
        assertThat(actual.getDisplayInfoImages().size()).isEqualTo(expected.getDisplayInfoImages().size());
        assertThat(actual.getAvgScore()).isEqualTo(expected.getAvgScore());
        assertThat(actual.getProductPrices().size()).isEqualTo(expected.getProductPrices().size());
    }

    public static DetailDisplayInfosResponseDto getDetailDisplayInfos() {
        return DetailDisplayInfosResponseDto.builder()
                .product(DisplayInfoResponseDto.builder().id(1).build())
                .productImages(List.of(ProductImageDto.builder().productId(1).build()))
                .displayInfoImages(List.of(DisplayInfoImageDto.builder().id(1).build()))
                .avgScore(3)
                .productPrices(
                        List.of(
                                ProductPrice.builder().id(3).build(),
                                ProductPrice.builder().id(2).build(),
                                ProductPrice.builder().id(1).build()
                        )
                )
                .build();
    }
}
