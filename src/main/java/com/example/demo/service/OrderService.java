package com.example.demo.service;

import com.example.demo.model.Order;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderService {
    private final Map<Long, Order> orders = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public OrderService() {
        // Add some static orders
        saveOrder(new Order(null, "Alice", "Margherita", 2, "NEW"));
        saveOrder(new Order(null, "Bob", "Pepperoni", 1, "NEW"));
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders.values());
    }

    public Optional<Order> getOrder(Long id) {
        return Optional.ofNullable(orders.get(id));
    }

    public Order saveOrder(Order order) {
        if (order.getId() == null) {
            order.setId(idCounter.getAndIncrement());
        }
        orders.put(order.getId(), order);
        return order;
    }

    public boolean deleteOrder(Long id) {
        return orders.remove(id) != null;
    }

    public Optional<Order> updateOrder(Long id, Order updatedOrder) {
        if (orders.containsKey(id)) {
            updatedOrder.setId(id);
            orders.put(id, updatedOrder);
            return Optional.of(updatedOrder);
        }
        return Optional.empty();
    }

    public Optional<Order> changeOrder(Long id, String status) {
        Order order = orders.get(id);
        if (order != null) {
            order.setStatus(status);
            return Optional.of(order);
        }
        return Optional.empty();
    }
}
