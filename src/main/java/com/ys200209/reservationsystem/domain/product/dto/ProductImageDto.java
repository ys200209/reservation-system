package com.ys200209.reservationsystem.domain.product.dto;

import com.ys200209.reservationsystem.utils.restdocs.RestDocsDto;
import com.ys200209.reservationsystem.utils.restdocs.RestDocsTemplate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;

@Builder
@Getter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class ProductImageDto implements RestDocsTemplate {
    private final int productId;
    private final int productImageId;
    private final String type;
    private final int fileInfoId;
    private final String fileName;
    private final String saveFileName;
    private final String contentType;
    private final int deleteFlag;
    private final LocalDateTime createDate;
    private final LocalDateTime modifyDate;

    public static final RowMapper<ProductImageDto> productImageMapper = (rs, rowNum) -> {
            return ProductImageDto.builder()
                .productId(rs.getInt("productId"))
                .productImageId(rs.getInt("productImageId"))
                .type(rs.getString("type"))
                .fileInfoId(rs.getInt("fileInfoId"))
                .fileName(rs.getString("fileName"))
                .saveFileName(rs.getString("saveFileName"))
                .contentType(rs.getString("contentType"))
                .deleteFlag(rs.getInt("deleteFlag"))
                .createDate(rs.getObject("createDate", LocalDateTime.class))
                .modifyDate(rs.getObject("modifyDate", LocalDateTime.class))
                .build();
    };

    @Override
    public List<RestDocsDto> generateRestDocsFields(String rootField) {
        return List.of(
                RestDocsDto.builder().path(rootField + ".productId").description("상품 아이디").build(),
                RestDocsDto.builder().path(rootField + ".productImageId").description("상품 이미지 아이디").build(),
                RestDocsDto.builder().path(rootField + ".type").description("상품 이미지 타입").build(),
                RestDocsDto.builder().path(rootField + ".fileInfoId").description("상품 이미지 파일 아이디").build(),
                RestDocsDto.builder().path(rootField + ".fileName").description("상품 이미지 파일명").build(),
                RestDocsDto.builder().path(rootField + ".saveFileName").description("상품 이미지 저장된 파일명").build(),
                RestDocsDto.builder().path(rootField + ".contentType").description("상품 이미지 Content Type").build(),
                RestDocsDto.builder().path(rootField + ".deleteFlag").description("상품 이미지 삭제 여부").build(),
                RestDocsDto.builder().path(rootField + ".createDate").description("상품 이미지 생성일").build(),
                RestDocsDto.builder().path(rootField + ".modifyDate").description("상품 이미지 수정일").build());
    }

    @Override
    public boolean isPathParameters() {
        return false;
    }
}