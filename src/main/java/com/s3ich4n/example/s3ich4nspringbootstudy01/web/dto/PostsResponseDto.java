package com.s3ich4n.example.s3ich4nspringbootstudy01.web.dto;

import com.s3ich4n.example.s3ich4nspringbootstudy01.domain.Posts;

import lombok.Getter;

@Getter
public class PostsResponseDto {
    
    private long id;
    private String title;
    private String content;
    private String author;

    /**
     * 얘는 Entity 일부만 사용함. 생성자에 Entity를 받아 필드에 값을 넣는다
     * @param entity
     */
    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
