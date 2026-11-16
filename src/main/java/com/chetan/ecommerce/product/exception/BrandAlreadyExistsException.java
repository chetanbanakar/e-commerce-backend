package com.chetan.ecommerce.product.exception;

import com.chetan.ecommerce.common.exception.BusinessException;

public class BrandAlreadyExistsException extends BusinessException {

    public BrandAlreadyExistsException(String identifier) {
        super("Brand already exists with identifier: " + identifier, "BRAND_ALREADY_EXISTS");
    }
}

