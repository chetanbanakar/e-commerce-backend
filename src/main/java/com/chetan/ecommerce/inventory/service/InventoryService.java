package com.chetan.ecommerce.inventory.service;

import com.chetan.ecommerce.common.apiResponse.PageResponseDto;
import com.chetan.ecommerce.inventory.dto.request.UpdateStockRequestDto;
import com.chetan.ecommerce.inventory.dto.response.InventoryResponseDto;
import org.springframework.data.domain.Pageable;

public interface InventoryService {

    /**
     * Create initial inventory record for a new product with 0 quantity
     */
    void createInitialInventory(Long productId);

    InventoryResponseDto increaseStock(Long productId, UpdateStockRequestDto requestDto);

    InventoryResponseDto reduceStock(Long productId, UpdateStockRequestDto requestDto);

    InventoryResponseDto getAvailableStock(Long productId);

    PageResponseDto<InventoryResponseDto> getInventoryBySeller(Long sellerId, Pageable pageable);

    PageResponseDto<InventoryResponseDto> getInventoryBySellerAndSearch(Long sellerId, String searchQuery, Pageable pageable);

    PageResponseDto<InventoryResponseDto> getAllInventory(Pageable pageable);
}

