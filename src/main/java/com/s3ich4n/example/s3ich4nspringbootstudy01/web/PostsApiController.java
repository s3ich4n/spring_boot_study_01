package com.s3ich4n.example.s3ich4nspringbootstudy01.web;

import com.s3ich4n.example.s3ich4nspringbootstudy01.service.posts.PostsService;
import com.s3ich4n.example.s3ich4nspringbootstudy01.web.dto.PostsResponseDto;
import com.s3ich4n.example.s3ich4nspringbootstudy01.web.dto.PostsSaveRequestDto;
import com.s3ich4n.example.s3ich4nspringbootstudy01.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto retrieve(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
