package net.javaguides.todo_management.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

public class JwtExample {
    public static void main(String[] args) {
        Key key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256); // 生成一个密钥
        String jws = Jwts.builder()
                .setSubject("javaguides")
                .signWith(key)
                .compact();

        System.out.println("Generated Token: " + jws);

        String parsedSubject = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jws)
                .getBody()
                .getSubject();

        System.out.println("Parsed Subject: " + parsedSubject);
    }
}

