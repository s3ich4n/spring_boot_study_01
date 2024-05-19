package com.s3ich4n.example.s3ich4nspringbootstudy01.web.dto;

import com.s3ich4n.example.s3ich4nspringbootstudy01.domain.Posts;

import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {
    private long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDateTime;

    /**
     * 얘는 Entity 일부만 사용함. 생성자에 Entity를 받아 필드에 값을 넣는다
     *
     * @param entity
     */
    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDateTime = entity.getModifiedDateTime();
    }
}
