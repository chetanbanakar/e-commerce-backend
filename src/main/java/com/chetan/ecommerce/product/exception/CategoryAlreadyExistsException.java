package com.chetan.ecommerce.product.exception;

import com.chetan.ecommerce.common.exception.BusinessException;

public class CategoryAlreadyExistsException extends BusinessException {

    public CategoryAlreadyExistsException(String identifier) {
        super("Category already exists with identifier: " + identifier, "CATEGORY_ALREADY_EXISTS");
    }
}

