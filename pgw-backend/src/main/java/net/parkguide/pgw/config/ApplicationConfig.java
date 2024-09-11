package net.parkguide.pgw.config;


import lombok.RequiredArgsConstructor;
import net.parkguide.pgw.repository.UserRepository;
import net.parkguide.pgw.service.AuthenticationService;
import net.parkguide.pgw.service.JwtService;
import net.parkguide.pgw.service.impl.AuthenticationServiceImpl;
import net.parkguide.pgw.service.impl.JwtServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UserRepository userRepository;

    @Bean
    public UserDetailsService userDetailsService(){
        return username -> userRepository.findByUserEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public JwtService jwtService() {
//        return new JwtServiceImpl();
//    }

//    @Bean
//    public AuthenticationService authenticationService() {
//        return new AuthenticationServiceImpl(userRepository, passwordEncoder(), jwtService(), authenticationManager);
//    }
}
