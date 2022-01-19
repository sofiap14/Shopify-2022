package com.example.rest.handler.impl;

import com.example.rest.model.Product;

import java.util.HashMap;
import java.util.Map;

public final class DataAccessor {

    private static Map<String, Product> productData = new HashMap<>();

    public DataAccessor() {
        productData.put("key1", Product.builder().productId("key1").productName("bread").price(776.9).build());
        productData.put("key2", Product.builder().productId("key2").productName("butter").price(77.9).build());
        productData.put("key3", Product.builder().productId("key3").productName("rice").price(800.0).build());
        productData.put("key4", Product.builder().productId("key4").productName("soup").price(16.99).build());

    }

    public Map<String, Product> getData() {
        return productData;
    }

    public void putData(Product product) {
        productData.put(product.getProductId(), product);
    }

    public void updateData(Product product) {
        productData.replace(product.getProductId(), product);
    }

    public void deleteData(Product product) { productData.remove(product.getProductId()); }

}
