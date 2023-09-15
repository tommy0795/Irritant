package org.edf.cat.mmesi.Irritant.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.edf.cat.mmesi.Irritant.auth.AuthRequest;
import org.edf.cat.mmesi.Irritant.auth.AuthResponse;
import org.edf.cat.mmesi.Irritant.auth.RegisterRequest;
import org.edf.cat.mmesi.Irritant.config.JwtService;
import org.edf.cat.mmesi.Irritant.model.Token;
import org.edf.cat.mmesi.Irritant.model.User;
import org.edf.cat.mmesi.Irritant.repositrory.TokenRepository;
import org.edf.cat.mmesi.Irritant.repositrory.UserRepository;
import org.edf.cat.mmesi.Irritant.security.token.TokenType;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;

    public AuthResponse register(RegisterRequest request) {
        var user = User.builder()
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .nni(request. getNni())
        .role(request.getRole())
        .build();
        var savedUser = userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        saveUserToken(savedUser, jwtToken);
        return AuthResponse.builder()
                .build();

    }

    public AuthResponse authenticate(AuthRequest request) {
        authManager.authenticate(
               new UsernamePasswordAuthenticationToken(request.getNni(), null));
        var user = userRepository.findByNni(request.getNni())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        saveUserToken(user, jwtToken);
        return AuthResponse.builder()

                .build();
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .isExpired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    public void refreshToken(HttpServletRequest request, HttpServletResponse response) {

    }
}
