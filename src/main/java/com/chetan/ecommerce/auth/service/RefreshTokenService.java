package com.chetan.ecommerce.auth.service;

import com.chetan.ecommerce.auth.entity.RefreshToken;
import com.chetan.ecommerce.user.entity.User;

public interface RefreshTokenService {
    RefreshToken createOrReplaceRefreshToken(User user);
    RefreshToken validateAndGet(String token);
    void deleteByUsername(String username);
}

