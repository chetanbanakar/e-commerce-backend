package com.chetan.ecommerce.user.exception;

import com.chetan.ecommerce.common.exception.BusinessException;

public class UserAlreadyExistsException extends BusinessException {

    public UserAlreadyExistsException(String email) {
        super("User already exists with email: " + email, "USER_ALREADY_EXISTS");
    }
}

