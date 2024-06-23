package com.example.inventory.presentation;

import com.example.inventory.business.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class InventoryController implements InventoryApi {

    private final InventoryService inventoryService;

    @Override
    public boolean isInStock(String skuCode, Integer quantity) {
        return inventoryService.isInStock(skuCode, quantity);
    }
}
