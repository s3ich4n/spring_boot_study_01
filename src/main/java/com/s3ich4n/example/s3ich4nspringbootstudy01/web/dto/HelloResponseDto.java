package com.s3ich4n.example.s3ich4nspringbootstudy01.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/** Lombok으로 getter 설정 뚝딱 final 객체만 있는 생성자를 만들어줌 */
@Getter
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
