package com.jiho.board.springbootaws.util;

import java.time.ZonedDateTime;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import io.jsonwebtoken.impl.DefaultJws;

public class JWTUtil {
    private String secretKey = "randomSecretNeedChange";
    private long expire = 60 * 24 * 7; // 일주일

    public String generateToken(String content) throws Exception {
        return Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(Date.from(ZonedDateTime.now().plusMinutes(expire).toInstant()))
                .claim("sub", content)
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes("UTF-8"))
                .compact();
    }

    public String validateAndExtract(String tokenStr) throws Exception {
        String contentValue = null;

        try {
            DefaultJws defaultJws = (DefaultJws) Jwts.parser()
                    .setSigningKey(secretKey.getBytes("UTF-8"));
            DefaultClaims claims = (DefaultClaims) defaultJws.getBody();
            contentValue = claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            contentValue = null;
        }

        return contentValue;
    }

}
