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
public class DisplayInfosRequestDto implements RestDocsTemplate {
    private final int categoryId;
    private final int start;

    @Override
    public List<RestDocsDto> generateRestDocsFields() {
        return List.of(
                RestDocsDto.builder().path("categoryId").description("카테고리 아이디 (0 또는 없을 경우 전체 조회)").build(),
                RestDocsDto.builder().path("start").description("조회 시작 위치").build()
        );
    }
}
