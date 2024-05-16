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

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

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
        //  https://assertj.github.io/doc/#use-assertions-class-entry-point
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
