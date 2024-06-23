package com.example.inventory.business;

public interface InventoryService {

    boolean isInStock(String skuCode, Integer quantity);
}
