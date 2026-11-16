package com.chetan.ecommerce.inventory.entity;

import com.chetan.ecommerce.common.baseEntity.BaseEntity;
import com.chetan.ecommerce.product.entity.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "inventory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inventory extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "product_id", unique = true)
    private Product product;

    private Integer quantity;

    @Version
    private Long version;
    
}

