package com.chetan.ecommerce.product.exception;

import com.chetan.ecommerce.common.exception.BusinessException;

public class ProductNotFoundException extends BusinessException {

    public ProductNotFoundException(Long id) {
        super("Product not found with id: " + id, "PRODUCT_NOT_FOUND");
    }
}

