package com.jiho.board.springbootaws.service.comments;

import javax.transaction.Transactional;

import com.jiho.board.springbootaws.domain.comments.CommentsRepository;
import com.jiho.board.springbootaws.domain.posts.Posts;
import com.jiho.board.springbootaws.domain.posts.PostsRepository;
import com.jiho.board.springbootaws.web.dto.comments.CommentsSaveRequestDto;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentsService {
    private final CommentsRepository commentsRepository;
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(CommentsSaveRequestDto requestDto) {
        Long postsId = requestDto.getPostsId();
        Posts posts = postsRepository.findById(postsId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + postsId));
        return commentsRepository.save(requestDto.toEntity(posts)).getId();
    }
}
