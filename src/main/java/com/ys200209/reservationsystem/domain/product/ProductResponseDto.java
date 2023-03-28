package com.ys200209.reservationsystem.domain.product;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class ProductResponseDto {
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
}
