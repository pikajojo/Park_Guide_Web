package net.parkguide.pgw.service;

import lombok.RequiredArgsConstructor;
import net.parkguide.pgw.config.AuthenticationRequest;
import net.parkguide.pgw.config.AuthenticationResponse;
import net.parkguide.pgw.config.RegisterRequest;
import net.parkguide.pgw.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service

public interface AuthenticationService {

    public AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
