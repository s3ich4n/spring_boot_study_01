package com.s3ich4n.example.s3ich4nspringbootstudy01.web;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @WebMvcTest(
//     controllers = PostsApiController.class,
//     webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
// )
public class PostsApiControllerTest {
    
}
