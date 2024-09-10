package net.parkguide.pgw.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface JwtService {
    String extractUserName(String jwt);
    public boolean isTokenValid(String token, UserDetails userDetails);
    public String generateToken(UserDetails userDetails);
}
