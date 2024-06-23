package com.example.product.presentation;

import com.example.product.business.Product;
import com.example.product.business.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController implements ProductApi {

    private final ProductService productService;

    @Override
    public Product createProduct(Product product) {
        return productService.createProduct(product);
    }

    @Override
    public List<Product> getProducts() {
        return productService.getProducts();
    }
}
