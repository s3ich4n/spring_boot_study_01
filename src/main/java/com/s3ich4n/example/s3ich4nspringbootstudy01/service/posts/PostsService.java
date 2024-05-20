package com.s3ich4n.example.s3ich4nspringbootstudy01.service.posts;

import com.s3ich4n.example.s3ich4nspringbootstudy01.domain.Posts;
import com.s3ich4n.example.s3ich4nspringbootstudy01.domain.PostsRepository;
import com.s3ich4n.example.s3ich4nspringbootstudy01.web.dto.PostsListResponseDto;
import com.s3ich4n.example.s3ich4nspringbootstudy01.web.dto.PostsResponseDto;
import com.s3ich4n.example.s3ich4nspringbootstudy01.web.dto.PostsSaveRequestDto;
import com.s3ich4n.example.s3ich4nspringbootstudy01.web.dto.PostsUpdateRequestDto;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 1. Bean을 주입받는 여러 방식 중, 생성자로 주입받는 방식이 가장 권장됨. 이를 위해 아래의 RequiredArgsConstructor 어노테이션을 사용함. 2. 쿼리를
 * 날리는 부분은 JPA의 영속성 컨텍스트로 인해 가능한 것임 JPA는 엔티티가 영속성 컨텍스트에 포함되어있는지 아닌지에 따라 달라짐
 */
@RequiredArgsConstructor // final 필드에 대한 생성자를 알아서 만들어줌
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts =
                postsRepository
                        .findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity =
                postsRepository
                        .findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).toList();
    }
}
