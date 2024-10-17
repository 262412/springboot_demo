package com.example.springboot_demo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringbootDemoApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    public void testGenJwt(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","tom");
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String jwt = Jwts.builder()
                .signWith(key)
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis()+60*60*1000))
                .compact();
        System.out.println(jwt);
    }
    @Test
    public void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey(Keys.secretKeyFor(SignatureAlgorithm.HS256))
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTcyOTE0OTk3M30.pEmNhiGnN3XEwBQV9uJ_It8LciSJrUaCsjOKGESkIaI")
                .getBody();
        System.out.println(claims);
    }

}
