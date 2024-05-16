package com.s3ich4n.example.s3ich4nspringbootstudy01.service.posts;

import org.springframework.stereotype.Service;

import com.s3ich4n.example.s3ich4nspringbootstudy01.domain.PostsRepository;
import com.s3ich4n.example.s3ich4nspringbootstudy01.web.dto.PostsSaveRequestDto;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


/**
 * Bean을 주입받는 여러 방식 중, 생성자로 주입받는 방식이 가장 권장됨.
 * 이를 위해 아래의 RequiredArgsConstructor 어노테이션을 사용함.
 */
@RequiredArgsConstructor    // final 필드에 대한 생성자를 알아서 만들어줌
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity())
                                .getId();
    }
}
