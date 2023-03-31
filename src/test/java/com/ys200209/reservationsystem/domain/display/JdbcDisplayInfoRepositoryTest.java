package com.ys200209.reservationsystem.domain.display;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfosRequestDto;
import com.ys200209.reservationsystem.domain.display.controller.dto.DisplayInfosResponseDto;
import com.ys200209.reservationsystem.domain.repository.JdbcReservationRepository;
import com.ys200209.reservationsystem.domain.repository.ReservationRepository;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.jdbc.core.JdbcTemplate;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class JdbcDisplayInfoRepositoryTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private JdbcDisplayInfoRepository repository;

    @BeforeEach
    void setUp() {
        repository = new JdbcDisplayInfoRepository(jdbcTemplate);
    }

    @ParameterizedTest
    @MethodSource("generateDisplayInfosRequestDto")
    void testApiDisplayInfos(DisplayInfosRequestDto requestDto, int expectedSize) {
        // when
        DisplayInfosResponseDto actual = repository.getDisplayInfos(requestDto);

        // then
//        assertThat(actual).isEqualTo(displayInfos); 모든 필드를 가지고 있지 않기 때문에 이런 간단한 방식으로는 검증할 수 없음.
        assertThat(actual.getTotalCount()).isEqualTo(16); // totalCount 검증
        assertThat(actual.getProductCount()).isEqualTo(4); // productCount 검증
        assertThat(actual.getProducts().size()).isEqualTo(expectedSize); // products 개수 검증
    }

    public static Stream<Arguments> generateDisplayInfosRequestDto() {
        return Stream.of(
                Arguments.of(DisplayInfosRequestDto.builder().categoryId(3).start(0).build(), 4),
                Arguments.of(DisplayInfosRequestDto.builder().categoryId(3).start(14).build(), 2)
        );
    }
}
