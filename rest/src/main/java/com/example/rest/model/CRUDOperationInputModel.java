package com.example.rest.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * The input model of the CRUD Operations API.
 */
@Getter
@Setter
public class CRUDOperationInputModel {

    /**
     * Specifies the type of the operation
     */
    @NonNull OperationType operation;

    /**
     * Describes the product.
     * Does not have to be present for all operations.
     */
    Product productDetails;

}
