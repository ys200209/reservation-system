package com.ys200209.reservationsystem.domain.display.controller.dto;

import com.ys200209.reservationsystem.utils.restdocs.RestDocsDto;
import com.ys200209.reservationsystem.utils.restdocs.RestDocsTemplate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.jdbc.core.RowMapper;

@Builder
@Getter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@EqualsAndHashCode
public class DisplayInfoResponseDto implements RestDocsTemplate {
    private final int id;
    private final int categoryId;
    private final int displayInfoId;
    private final String name;
    private final String description;
    private final String content;
    private final String event;
    private final String openingHours;
    private final String placeName;
    private final String placeLot;
    private final String placeStreet;
    private final String tel;
    private final String homepage;
    private final String email;
    private final LocalDateTime createDate;
    private final LocalDateTime modifyDate;
    private final int fileId;

    public static final RowMapper<DisplayInfoResponseDto> displayInfoMapper = (rs, rowNum) -> {
        int id = rs.getInt("id");
        int categoryId = rs.getInt("categoryId");
        int displayInfoId = rs.getInt("displayInfoId");
        String name = rs.getString("name");
        String description = rs.getString("description");
        String content = rs.getString("content");
        String event = rs.getString("event");
        String openingHours = rs.getString("openingHours");
        String placeName = rs.getString("placeName");
        String placeLot = rs.getString("placeLot");
        String placeStreet = rs.getString("placeStreet");
        String tel = rs.getString("tel");
        String homepage = rs.getString("homepage");
        String email = rs.getString("email");
        LocalDateTime createDate = rs.getObject("createDate", LocalDateTime.class);
        LocalDateTime modifyDate = rs.getObject("modifyDate", LocalDateTime.class);
        int fileId = rs.getInt("fileId");

        return new DisplayInfoResponseDto(id, categoryId, displayInfoId, name, description,
                content, event, openingHours, placeName, placeLot, placeStreet, tel,
                homepage, email, createDate, modifyDate, fileId);
    };

    @Override
    public List<RestDocsDto> generateRestDocsFields(String rootField) {
        return List.of(
                RestDocsDto.builder().path(rootField + ".id").description("전시 상품 ID").build(),
                RestDocsDto.builder().path(rootField + ".categoryId").description("카테고리 ID").build(),
                RestDocsDto.builder().path(rootField + ".displayInfoId").description("전시 상품 ID").build(),
                RestDocsDto.builder().path(rootField + ".name").description("전시 상품명").build(),
                RestDocsDto.builder().path(rootField + ".description").description("전시 상품 설명").build(),
                RestDocsDto.builder().path(rootField + ".content").description("전시 상품 내용").build(),
                RestDocsDto.builder().path(rootField + ".event").description("이벤트").build(),
                RestDocsDto.builder().path(rootField + ".openingHours").description("오픈 시각").build(),
                RestDocsDto.builder().path(rootField + ".placeName").description("장소").build(),
                RestDocsDto.builder().path(rootField + ".placeLot").description("위치").build(),
                RestDocsDto.builder().path(rootField + ".placeStreet").description("도로명").build(),
                RestDocsDto.builder().path(rootField + ".tel").description("연락처").build(),
                RestDocsDto.builder().path(rootField + ".homepage").description("홈페이지").build(),
                RestDocsDto.builder().path(rootField + ".email").description("이메일").build(),
                RestDocsDto.builder().path(rootField + ".createDate").description("생성일").build(),
                RestDocsDto.builder().path(rootField + ".modifyDate").description("수정일").build(),
                RestDocsDto.builder().path(rootField + ".fileId").description("파일 ID").build());
    }

    @Override
    public boolean isPathParameters() {
        return false;
    }
}
