package com.ys200209.reservationsystem.domain.display;

import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfoImageDto;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfoResponseDto;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfosRequestDto;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfosResponseDto;
import com.ys200209.reservationsystem.domain.display.utils.DisplayInfoSQLMapper;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JdbcDisplayInfoRepository implements DisplayInfoRepository {
    private static final int SHOW_PRODUCT_COUNT_AMOUNT = 4;

    private final JdbcTemplate jdbcTemplate;

    @Override
    public DisplayInfoResponseDto getDisplayInfo(int displayId) {
        return jdbcTemplate.queryForObject(DisplayInfoSQLMapper.SELECT_DISPLAY_INFO_QUERY,
                DisplayInfoResponseDto.displayInfoMapper,
                displayId);
    }

    @Override
    public DisplayInfosResponseDto getDisplayInfos(DisplayInfosRequestDto requestDto) {
        List<DisplayInfoResponseDto> results = jdbcTemplate.query(
                DisplayInfoSQLMapper.SELECT_DISPLAY_INFOS_QUERY,
                DisplayInfoResponseDto.displayInfoMapper,
                requestDto.getCategoryId()
        );
        return new DisplayInfosResponseDto(results.size(), SHOW_PRODUCT_COUNT_AMOUNT,
                getProductCountResult(results, requestDto));
    }

    @Override
    public List<DisplayInfoImageDto> getDisplayInfoImages(int displayId) {
        return jdbcTemplate.query(
                DisplayInfoSQLMapper.SELECT_DISPLAY_INFO_IMAGES,
                DisplayInfoImageDto.displayInfoImageMapper,
                displayId
        );
    }

    private List<DisplayInfoResponseDto> getProductCountResult(List<DisplayInfoResponseDto> results,
                                                               DisplayInfosRequestDto requestDto) {
        int start = requestDto.getStart(); // 조회를 시작할 인덱스
        int end = start + SHOW_PRODUCT_COUNT_AMOUNT; // 조회를 마칠 인덱스
        if (end >= results.size()) { // 조회할 인덱스가 상품 개수보다 많다면
            end = results.size();
        }

        return IntStream.range(start, end)
                .mapToObj(results::get)
                .collect(Collectors.toList());
    }
}
