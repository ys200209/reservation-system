package com.ys200209.reservationsystem.domain.display.controller.dto;

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
public class DisplayInfoImageDto implements RestDocsTemplate {
    private final int id;
    private final int displayInfoId;
    private final int fileId;
    private final String fileName;
    private final String saveFileName;
    private final String contentType;
    private final int deleteFlag;
    private final LocalDateTime createDate;
    private final LocalDateTime modifyDate;

    public static final RowMapper<DisplayInfoImageDto> displayInfoImageMapper = (rs, rowNum) -> {
        return DisplayInfoImageDto.builder()
                .id(rs.getInt("id"))
                .displayInfoId(rs.getInt("displayInfoId"))
                .fileId(rs.getInt("fileId"))
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
                RestDocsDto.builder().path(rootField + ".id").description("전시 이미지 아이디").build(),
                RestDocsDto.builder().path(rootField + ".displayInfoId").description("전시 정보 아이디").build(),
                RestDocsDto.builder().path(rootField + ".fileId").description("전시 이미지 파일 이미지").build(),
                RestDocsDto.builder().path(rootField + ".fileName").description("전시 이미지 파일명").build(),
                RestDocsDto.builder().path(rootField + ".saveFileName").description("전시 이미지 저장된 파일명").build(),
                RestDocsDto.builder().path(rootField + ".contentType").description("전시 이미지 Content Type").build(),
                RestDocsDto.builder().path(rootField + ".deleteFlag").description("전시 이미지 삭제 여부").build(),
                RestDocsDto.builder().path(rootField + ".createDate").description("전시 이미지 생성일").build(),
                RestDocsDto.builder().path(rootField + ".modifyDate").description("전시 이미지 수정일").build());
    }

    @Override
    public boolean isPathParameters() {
        return false;
    }
}
