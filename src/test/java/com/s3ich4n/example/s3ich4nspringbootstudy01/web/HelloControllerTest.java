package com.s3ich4n.example.s3ich4nspringbootstudy01.web;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.test.web.servlet.MockMvc;

/** JUnit 에 내장된 실행자 외에 다른 실행자를 실행시킴. WebMvc 중점으로 테스트함. Controller 테스트를 위함 */
@WebMvcTest(HelloController.class)
@MockBean(JpaMetamodelMappingContext.class)
public class HelloControllerTest {

    // 스프링이 관리하는 Bean을 주입받음
    @Autowired private MockMvc mvc;

    @Test
    @DisplayName("Hello 리턴 확인하기")
    public void hello_리턴() throws Exception {
        String hello = "Hello World";

        mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));
    }

    @Test
    @DisplayName("Hello DTO 리턴 확인하기")
    public void helloDto_리턴() throws Exception {
        String name = "hello";
        int amount = 42;

        // 유의: param 값은 string 만 가능
        mvc.perform(get("/hello/dto").param("name", name).param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
