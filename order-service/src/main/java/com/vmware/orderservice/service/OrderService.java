package com.vmware.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.vmware.orderservice.repository.OrderRepository;
import com.vmware.orderservice.model.OnlineOrder;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<OnlineOrder> getAllOrders() {
        return orderRepository.findAll();
    }
}