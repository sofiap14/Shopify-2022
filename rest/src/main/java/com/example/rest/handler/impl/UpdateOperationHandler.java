package com.example.rest.handler.impl;

import com.example.rest.handler.OperationHandler;
import com.example.rest.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
@RequiredArgsConstructor
public class UpdateOperationHandler implements OperationHandler {

    @Autowired
    private final DataAccessor dataAccessor;

    /**
     * {@inheritDoc}
     */
    @Override
    public String handle(Product productDetails) {
        dataAccessor.updateData(productDetails);
        return null;
    }
}
