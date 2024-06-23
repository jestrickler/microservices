package com.example.product.business;

import com.example.product.data.ProductEntity;
import com.example.product.data.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        ProductEntity productEntity = ProductEntity.builder()
                .name(product.name())
                .description(product.description())
                .price(product.price())
                .build();
        productRepository.save(productEntity);
        log.info("Product created");
        return mapTopProduct(productEntity);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll().stream().map(this::mapTopProduct).toList();
    }

    private Product mapTopProduct(ProductEntity productEntity) {
        return new Product(productEntity.getId(), productEntity.getName(), productEntity.getDescription(), productEntity.getPrice());
    }
}
