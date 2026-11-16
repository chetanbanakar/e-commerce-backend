package com.chetan.ecommerce.auth.service.impl;

import com.chetan.ecommerce.auth.dto.OAuthResponseDto;
import com.chetan.ecommerce.auth.service.OAuthService;
import com.chetan.ecommerce.security.jwt.JwtUtil;
import com.chetan.ecommerce.shared.enums.AuthProvider;
import com.chetan.ecommerce.shared.enums.Role;
import com.chetan.ecommerce.user.entity.User;
import com.chetan.ecommerce.shared.enums.UserStatus;
import com.chetan.ecommerce.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class OAuthServiceImpl implements OAuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Override
    public OAuthResponseDto handleOAuthLogin(OAuth2User oAuth2User, String provider) {

        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");

        User user = userRepository.findByEmail(email)
                .orElseGet(() -> {
                    User newUser = new User();
                    newUser.setEmail(email);
                    newUser.setFullName(name);
                    newUser.setRoles(Set.of(Role.ROLE_USER));
                    newUser.setStatus(UserStatus.ACTIVE);
                    newUser.setProvider(AuthProvider.valueOf(provider.toUpperCase()));
                    return userRepository.save(newUser);
                });

        String token = jwtUtil.generateToken(user.getEmail(), user.getRoles().stream().map(Role::name).toList());

        return OAuthResponseDto.builder()
                .email(user.getEmail())
                .token(token)
                .message("OAuth login successful")
                .build();
    }
}


