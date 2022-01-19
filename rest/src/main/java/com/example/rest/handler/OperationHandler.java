package com.example.rest.handler;

import com.example.rest.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

/**
 * This interface represents the operations of each handler.
 */
public interface OperationHandler {

    /**
     * Performs the operation based on the type of the handler
     *
     * @param productDetails - {@link Product}
     * @return output of the operation.
     */
    String handle(Product productDetails) throws IOException;
}
