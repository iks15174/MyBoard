package com.jiho.board.springbootaws.service.member.dto;

import java.util.Collection;

import com.jiho.board.springbootaws.domain.member.Social;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AuthMemberDto extends User {
    private String name;
    private Social social;

    public AuthMemberDto(String email, String password, String name, Social social,
            Collection<? extends GrantedAuthority> authorities) {
        super(email, password, authorities);
        this.name = name;
        this.social = social;
    }
}
