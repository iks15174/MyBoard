package com.jiho.board.springbootaws.web;

import com.jiho.board.springbootaws.service.member.MemberService;
import com.jiho.board.springbootaws.web.dto.member.MemberResponseDto;
import com.jiho.board.springbootaws.web.dto.member.MemberSaveRequestDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/api/v1/auth/signup")
    public MemberResponseDto singup(@RequestBody MemberSaveRequestDto requestDto) {
        System.out.println(requestDto.toString());
        return memberService.signup(requestDto);
    }

}
