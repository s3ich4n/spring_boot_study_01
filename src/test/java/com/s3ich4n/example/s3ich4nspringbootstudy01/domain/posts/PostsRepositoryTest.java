package com.s3ich4n.example.s3ich4nspringbootstudy01.domain.posts;

import com.s3ich4n.example.s3ich4nspringbootstudy01.domain.Posts;
import com.s3ich4n.example.s3ich4nspringbootstudy01.domain.PostsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    private PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    @DisplayName("게시글 불러오기")
    public void 게시글을_정상적으로_불러온다() {
        // given
        String title = "제목";
        String content = "본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("s3ich4n@gmail.com")
                .build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        //  then 구문을 표현하면서 C#의 fluent assertions 처럼 쓰는 assertJ 라는 녀석이 있다
        //  첫 커밋은 JUnit5의 요소를 쓰고, 그 다음부턴 assertJ를 갖고와서 써보자.
        //  ref. https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions-third-party
        Posts posts = postsList.get(0);
        assertEquals(title, posts.getTitle());
        assertEquals(content, posts.getContent());
    }
}
