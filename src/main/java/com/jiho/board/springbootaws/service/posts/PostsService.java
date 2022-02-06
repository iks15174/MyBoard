package com.jiho.board.springbootaws.service.posts;

import javax.transaction.Transactional;

import com.jiho.board.springbootaws.domain.posts.PostsRepository;
import com.jiho.board.springbootaws.web.dto.PostsSaveRequestDto;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
