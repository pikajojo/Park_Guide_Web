package net.parkguide.pgw.service;


import org.springframework.stereotype.Service;

@Service
public interface JwtService {
    String extractUserName(String jwt);
}
