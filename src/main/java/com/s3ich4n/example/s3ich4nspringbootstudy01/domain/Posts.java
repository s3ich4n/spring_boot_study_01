package com.s3ich4n.example.s3ich4nspringbootstudy01.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Getter     // Setter가 없음에 유의. 값 변경은 별도 메소드로 처리할 것.
@NoArgsConstructor
@Entity     // 테이블과 매핑할 클래스 (underscore로 테이블 이름을 매칭해줌)
public class Posts {

    /**
     * 엔티티 PK는 이런식의 값이나 snowflake를 쓰면 어떨까 싶다
     * 복합키는 유니크 키로 별도 추가하는 편이 더 낫다
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // 내가 쓰는 DB의 auto increment 전략에 따라 다르게 쓰기
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder    // 빌더 패턴을 여기에 해결해줌
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
