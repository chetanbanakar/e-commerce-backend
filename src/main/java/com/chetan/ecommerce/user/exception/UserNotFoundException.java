package com.chetan.ecommerce.user.exception;

import com.chetan.ecommerce.common.exception.BusinessException;

public class UserNotFoundException extends BusinessException {

    public UserNotFoundException(Long id) {
        super("User not found with id: " + id, "USER_NOT_FOUND");
    }
}

