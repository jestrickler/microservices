package com.example.product.presentation;

import com.example.product.business.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/products")
public interface ProductApi {

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    Product createProduct(@RequestBody Product product);

    @GetMapping()
    List<Product> getProducts();
}
