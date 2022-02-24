package com.jiho.board.springbootaws.service.member.dto;

import java.util.Map;

import com.jiho.board.springbootaws.domain.member.Social;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OAuth2Attribute {
    private String email;
    private String name;
    private Social social;

    public static OAuth2Attribute of(String provider, Map<String, Object> attributes) {
        switch (provider.toLowerCase()) {
            case "google":
                return ofGoogle(provider, attributes);
            default:
                throw new RuntimeException();
        }
    }

    public static OAuth2Attribute ofGoogle(String provider, Map<String, Object> attributes) {
        return OAuth2Attribute.builder()
                .email((String) attributes.get("email"))
                .name((String) attributes.get("name"))
                .social((Social) Social.valueOf(provider))
                .build();
    }
}
