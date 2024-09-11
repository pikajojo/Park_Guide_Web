package net.parkguide.pgw.service;


import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Function;

@Service
public interface JwtService {
    static final String SECRET_KEY = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";
    String extractUserName(String jwt);
    public boolean isTokenValid(String token, UserDetails userDetails);
    public String generateToken(UserDetails userDetails);
    boolean isTokenExpired(String token);
    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);
}
