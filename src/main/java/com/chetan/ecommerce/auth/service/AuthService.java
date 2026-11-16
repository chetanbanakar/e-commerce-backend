package com.chetan.ecommerce.auth.service;

import com.chetan.ecommerce.auth.dto.AuthResponseDto;
import com.chetan.ecommerce.auth.dto.LoginRequestDto;
import com.chetan.ecommerce.auth.dto.SignupRequestDto;
import com.chetan.ecommerce.auth.dto.SignupResponseDto;

public interface AuthService {

    SignupResponseDto signup(SignupRequestDto request);

    AuthResponseDto login(LoginRequestDto request);
}

