package com.ys200209.reservationsystem.domain.display;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.jdbc.core.RowMapper;

@Builder
@Getter
@ToString
@RequiredArgsConstructor
public class DisplayInfoResponseDto {
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
}
