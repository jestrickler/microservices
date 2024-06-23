package com.example.order.presentation;

import com.example.order.business.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/orders")
public interface OrderApi {

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    Order placeOrder(@RequestBody Order order);
}
