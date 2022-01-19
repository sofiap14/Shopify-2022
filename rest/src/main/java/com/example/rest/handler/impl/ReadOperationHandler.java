package com.example.rest.handler.impl;

import com.example.rest.handler.OperationHandler;
import com.example.rest.model.Product;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Component
@Service
@RequiredArgsConstructor
public class ReadOperationHandler implements OperationHandler {

    @Autowired
    private final DataAccessor dataAccessor;

    /**
     * {@inheritDoc}
     */
    @Override
    public String handle(Product productDetails) {
        Map<String, Product> dataMap = dataAccessor.getData();
        Gson gson = new Gson();
        return gson.toJson(dataMap);
    }

}
