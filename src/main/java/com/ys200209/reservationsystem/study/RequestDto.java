package com.ys200209.reservationsystem.study;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RequestDto {
    private final long id;
    private final String name;
}
