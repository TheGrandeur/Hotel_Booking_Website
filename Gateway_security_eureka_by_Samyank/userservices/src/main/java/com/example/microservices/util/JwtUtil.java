package com.example.microservices.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Arrays;
import java.util.Date;

@Component
public class JwtUtil {
    private String SECRET_KEY = "TaK+HaV^uvCHEFsEVfypW#7g9^k*Z8$V";

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String generateToken(String username){

        return Jwts.builder()
                .setSubject(username)
                .claim("roles", Arrays.asList("USER"))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 15*60*1000))
                .signWith(getSigningKey())
                .compact();

    }

}
