package com.ys200209.reservationsystem.domain.detaildisplay;

import com.ys200209.reservationsystem.domain.comment.CommentRepository;
import com.ys200209.reservationsystem.domain.detaildisplay.controller.dto.DetailDisplayInfosRequestDto;
import com.ys200209.reservationsystem.domain.detaildisplay.controller.dto.DetailDisplayInfosResponseDto;
import com.ys200209.reservationsystem.domain.display.DisplayInfoRepository;
import com.ys200209.reservationsystem.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetailDisplayInfoService {
    private final DisplayInfoRepository displayInfoRepository;
    private final ProductRepository productRepository;
    private final CommentRepository commentRepository;

    public DetailDisplayInfosResponseDto getDetailDisplayInfos(DetailDisplayInfosRequestDto requestDto) {
        return DetailDisplayInfosResponseDto.builder()
                .product(displayInfoRepository.getDisplayInfo(requestDto.getDisplayId()))
                .productImages(productRepository.getProductImages(requestDto.getDisplayId()))
                .displayInfoImages(displayInfoRepository.getDisplayInfoImages(requestDto.getDisplayId()))
                .avgScore(commentRepository.getCommentsScoreByDisplayId(requestDto.getDisplayId()).getAvgScore())
                .productPrices(productRepository.getProductPrice(requestDto.getDisplayId()))
                .build();
    }
}
