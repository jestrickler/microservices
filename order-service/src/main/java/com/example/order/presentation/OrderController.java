package com.example.order.presentation;

import com.example.order.business.Order;
import com.example.order.business.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController implements OrderApi {

    private final OrderService orderService;

    @Override
    public Order placeOrder(Order order) {
        return orderService.placeOrder(order);
    }
}
