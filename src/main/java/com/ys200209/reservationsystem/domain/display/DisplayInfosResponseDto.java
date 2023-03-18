package com.ys200209.reservationsystem.domain.display;

import com.ys200209.reservationsystem.utils.restdocs.RestDocsDto;
import com.ys200209.reservationsystem.utils.restdocs.RestDocsTemplate;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class DisplayInfosResponseDto implements RestDocsTemplate {
    private final int totalCount;
    private final int productCount;
    private final List<DisplayInfoResponseDto> products;

    @Override
    public List<RestDocsDto> generateRestDocsFields() {
        return List.of(
                RestDocsDto.builder().path("totalCount").description("해당 카테고리의 전시 상품 수").build(),
                RestDocsDto.builder().path("productCount").description("읽어온 전시 상품 수").build(),
                RestDocsDto.builder().path("products[]").description("전시 상품 정보").build(),
                RestDocsDto.builder().path("products[].id").description("전시 상품 ID").build(),
                RestDocsDto.builder().path("products[].categoryId").description("카테고리 ID").build(),
                RestDocsDto.builder().path("products[].displayInfoId").description("전시 상품 ID").build(),
                RestDocsDto.builder().path("products[].name").description("전시 상품명").build(),
                RestDocsDto.builder().path("products[].description").description("전시 상품 설명").build(),
                RestDocsDto.builder().path("products[].content").description("전시 상품 내용").build(),
                RestDocsDto.builder().path("products[].event").description("이벤트").build(),
                RestDocsDto.builder().path("products[].openingHours").description("오픈 시각").build(),
                RestDocsDto.builder().path("products[].placeName").description("장소").build(),
                RestDocsDto.builder().path("products[].placeLot").description("위치").build(),
                RestDocsDto.builder().path("products[].placeStreet").description("도로명").build(),
                RestDocsDto.builder().path("products[].tel").description("연락처").build(),
                RestDocsDto.builder().path("products[].homepage").description("홈페이지").build(),
                RestDocsDto.builder().path("products[].email").description("이메일").build(),
                RestDocsDto.builder().path("products[].createDate").description("생성일").build(),
                RestDocsDto.builder().path("products[].modifyDate").description("수정일").build(),
                RestDocsDto.builder().path("products[].fileId").description("파일 ID").build()
        );
    }
}
