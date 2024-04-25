package com.s3ich4n.example.s3ich4nspringbootstudy01.web.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    @DisplayName("롬복 기능 테스트")
    public void test_롬복_기능() {
        // given
        String name = "test";
        int amount = 42;

        // when
        HelloResponseDto helloResponseDto = new HelloResponseDto(name, amount);

        // then
        assertThat(helloResponseDto.getName()).isEqualTo(name);
        assertThat(helloResponseDto.getAmount()).isEqualTo(amount);
    }
}
