package com.jiho.board.springbootaws.service.comments;

import javax.transaction.Transactional;

import com.jiho.board.springbootaws.domain.comments.CommentsRepository;
import com.jiho.board.springbootaws.domain.member.Member;
import com.jiho.board.springbootaws.domain.member.MemberRepository;
import com.jiho.board.springbootaws.domain.posts.Posts;
import com.jiho.board.springbootaws.domain.posts.PostsRepository;
import com.jiho.board.springbootaws.exception.exceptions.CustomBasicException;
import com.jiho.board.springbootaws.exception.exceptions.ErrorCode;
import com.jiho.board.springbootaws.service.member.dto.AuthMemberDto;
import com.jiho.board.springbootaws.web.dto.comments.CommentsSaveRequestDto;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentsService {
    private final CommentsRepository commentsRepository;
    private final PostsRepository postsRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long save(CommentsSaveRequestDto requestDto) {
        AuthMemberDto memberDto = (AuthMemberDto) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        Member author = memberRepository
                .findByEmailAndSocial(memberDto.getUsername(), memberDto.getSocial())
                .orElseThrow(() -> new CustomBasicException(ErrorCode.UNEIXIST_USER));

        Long postsId = requestDto.getPostsId();
        Posts posts = postsRepository.findById(postsId)
                .orElseThrow(() -> new CustomBasicException(ErrorCode.UNEIXIST_POST));
        return commentsRepository.save(requestDto.toEntity(posts, author)).getId();
    }
}
