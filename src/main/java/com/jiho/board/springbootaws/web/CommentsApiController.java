package com.jiho.board.springbootaws.web;

import com.jiho.board.springbootaws.domain.member.MemberRole;
import com.jiho.board.springbootaws.service.comments.CommentsService;
import com.jiho.board.springbootaws.web.dto.comments.CommentsListResponseDto;
import com.jiho.board.springbootaws.web.dto.comments.CommentsResponseDto;
import com.jiho.board.springbootaws.web.dto.comments.CommentsSaveRequestDto;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/api/v1/comments")
    public CommentsListResponseDto getComments(
            @RequestParam Long postsId,
            @PageableDefault(size = 10, sort = "createdDate") Pageable pageable) {
        return commentsService.getList(postsId, pageable);
    }

}
