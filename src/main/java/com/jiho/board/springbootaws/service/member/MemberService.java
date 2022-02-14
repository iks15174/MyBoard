package com.jiho.board.springbootaws.service.member;

import javax.transaction.Transactional;

import com.jiho.board.springbootaws.domain.member.Member;
import com.jiho.board.springbootaws.domain.member.MemberRepository;
import com.jiho.board.springbootaws.web.dto.member.MemberResponseDto;
import com.jiho.board.springbootaws.web.dto.member.MemberSaveRequestDto;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public MemberResponseDto signup(MemberSaveRequestDto requestDto) {
        if (memberRepository.existsByEmailAndSocial(requestDto.getEmail(), requestDto.getSocial())) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다");
        }

        Member member = requestDto.toEntity(passwordEncoder);
        return new MemberResponseDto(memberRepository.save(member));
    }
}
