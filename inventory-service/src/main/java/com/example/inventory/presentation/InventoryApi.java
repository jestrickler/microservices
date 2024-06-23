package com.example.inventory.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/inventories")
public interface InventoryApi {

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
}
