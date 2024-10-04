package com.example.planflow.jwt;

import com.example.planflow.dto.ResponseUserDTO;
import com.example.planflow.exception.NotFoundException;
import com.example.planflow.models.User;
import com.example.planflow.services.UserService;
import io.jsonwebtoken.Claims;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final Map<String, String> refreshStorage = new HashMap<>();
    private final JwtProvider jwtProvider;

    public JwtResponse login(@NotNull JwtRequest authRequest){
        final ResponseUserDTO user = userService.getUserByEmail(authRequest.getLogin());
        if(user != null){
            if(user.getPassword().equals(authRequest.getPassword())){
                final String accessToken = jwtProvider.generateAccessToken(user);
                final String refreshToken = jwtProvider.generateRefreshToken(user);
                refreshStorage.put(user.getEmail(), refreshToken);
                return new JwtResponse(accessToken, refreshToken);
            }
            throw new RuntimeException("Wrong password");

        }
        throw new NotFoundException("User not found",404L);
    }

    public JwtResponse getAccessToken(@NotNull String refreshToken){
        if(jwtProvider.validateRefreshToken(refreshToken)){
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String email = claims.getSubject();
            final String saveRefreshToken = refreshStorage.get(email);
            if(saveRefreshToken != null && saveRefreshToken.equals(refreshToken)){
                final ResponseUserDTO user = userService.getUserByEmail(email);
                if(user != null){
                    final String accessToken = jwtProvider.generateAccessToken(user);
                    return new JwtResponse(accessToken, null);
                }
                throw new NotFoundException("User not found",404L);
            }
        }
        throw new RuntimeException("Invalid JWT token");
    }

    public JwtResponse refresh(@NotNull String refreshToken){
        if(jwtProvider.validateAccessToken(refreshToken)){
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String email = claims.getSubject();
            final String saveRefreshToken = refreshStorage.get(email);
            if(saveRefreshToken != null && saveRefreshToken.equals(refreshToken)){
                final ResponseUserDTO user = userService.getUserByEmail(email);
                if(user != null){
                    final String accessToken = jwtProvider.generateAccessToken(user);
                    final String newRefreshToken = jwtProvider.generateRefreshToken(user);
                    refreshStorage.put(user.getEmail(), newRefreshToken);
                    return new JwtResponse(accessToken, newRefreshToken);

                }
                throw new NotFoundException("User not found",404L);
            }
        }
        throw new RuntimeException("Invalid JWT token");
    }
    public JwtAuthentication getAuthInfo(){
        return (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();
    }
}
