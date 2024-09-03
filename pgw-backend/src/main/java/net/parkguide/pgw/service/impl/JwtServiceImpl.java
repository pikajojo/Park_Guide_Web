package net.parkguide.pgw.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import net.parkguide.pgw.service.JwtService;

import java.security.Key;

public class JwtServiceImpl implements JwtService {

    private static final String SECRET_KEY = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";
    @Override
    public String extractUserName(String token) {
        return null;
    }


    private Claims extractAllClaims(String token){
        return Jwts.
                parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        return null;
    }
}
