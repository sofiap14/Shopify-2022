package com.example.rest.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * POJO to represent the structure of a Product record.
 */
@Getter
@Setter
@Builder
public class Product {

    /**
     * Used to identify a product uniquely
     */
    @NonNull String productId;

    /**
     * Name of the product
     */
    String productName;

    /**
     * Price of the product
     */
    Double price;

}
