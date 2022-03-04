package com.jiho.board.springbootaws.web;

import com.jiho.board.springbootaws.domain.member.MemberRole;
import com.jiho.board.springbootaws.service.comments.CommentsService;
import com.jiho.board.springbootaws.web.dto.comments.CommentsSaveRequestDto;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CommentsApiController {

    private final CommentsService commentsService;

    @Secured(MemberRole.ROLES.USER)
    @PostMapping("/api/v1/comments")
    public Long save(@RequestBody CommentsSaveRequestDto requestDto) {
        return commentsService.save(requestDto);
    }

}
