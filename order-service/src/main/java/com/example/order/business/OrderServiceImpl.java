package com.example.order.business;

import com.example.order.client.InventoryClient;
import com.example.order.data.OrderEntity;
import com.example.order.data.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    @Override
    public Order placeOrder(Order order) {
        var isInStock = inventoryClient.isInStock(order.skuCode(), order.quantity());

        if (isInStock) {
            OrderEntity orderEntity = OrderEntity.builder()
                    .skuCode(order.skuCode())
                    .price(order.price())
                    .quantity(order.quantity()).build();
            orderEntity.setOrderNumber(UUID.randomUUID().toString());
            orderRepository.save(orderEntity);
            return mapToOrder(orderEntity);
        } else {
            throw new RuntimeException(order.skuCode() + " is not in stock");
        }
    }

    private Order mapToOrder(OrderEntity orderEntity) {
        return new Order(orderEntity.getId(), orderEntity.getOrderNumber(), orderEntity.getSkuCode(), orderEntity.getPrice(), orderEntity.getQuantity());
    }
}
