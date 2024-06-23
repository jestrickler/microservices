package com.example.order.business;

import java.math.BigDecimal;

public record Order(Long id, String orderNumber, String skuCode, BigDecimal price, Integer quantity) {
}
