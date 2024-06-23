package com.example.product.business;

import java.math.BigDecimal;

public record Product(String id, String name, String description, BigDecimal price) {}
