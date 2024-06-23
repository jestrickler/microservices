package com.example.product.business;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);
    List<Product> getProducts();
}
