package com.vmware.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitTemplateConfigurer;
import org.springframework.stereotype.Service;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import com.vmware.orderservice.processor.OrderProcessingConfig;

import java.util.List;
import com.vmware.orderservice.repository.OrderRepository;
import com.vmware.orderservice.model.OnlineOrder;


@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public List<OnlineOrder> getAllOrders() {
        return orderRepository.findAll();
    }
    
    public boolean processOrder(OnlineOrder order) {
        // Save order to database
    	OnlineOrder savedOrder = orderRepository.save(order);
    	System.out.println("Saved new order recieved to db with order id : "+order.getId());

        // Here you can implement the logic to push the order to the queue for processing
    	System.out.println("Initiating order processing for order id : "+order.getId());
        processOrderPayment(order.getId());
        processOrderInventory(order.getId());
        processOrderShipping(order.getId());
        
        return savedOrder != null; // Return true if order is successfully processed
    }
    
    public void processOrderPayment(Long orderId) {
        // Simulate processing payment and send order to the payment queue
        rabbitTemplate.convertAndSend(OrderProcessingConfig.ORDER_DIRECT_EXCHANGE, OrderProcessingConfig.ROUTING_KEY_PAYMENT, orderId);
    }

    public void processOrderInventory(Long orderId) {
        // Simulate managing inventory and send order to the inventory queue
        rabbitTemplate.convertAndSend(OrderProcessingConfig.ORDER_DIRECT_EXCHANGE, OrderProcessingConfig.ROUTING_KEY_INVENTORY, orderId);
    }

    public void processOrderShipping(Long orderId) {
        // Simulate shipping and send order to the shipping queue
        rabbitTemplate.convertAndSend(OrderProcessingConfig.ORDER_DIRECT_EXCHANGE, OrderProcessingConfig.ROUTING_KEY_SHIPPING, orderId);
    }
    
    
}


/*
@MessageEndpoint
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    
    @ServiceActivator(inputChannel = "orderRequestChannel", outputChannel = "orderResponseChannel")
    public boolean processOrder(OnlineOrder order) {
        // Process the order (e.g., save to database)
        OnlineOrder savedOrder = orderRepository.save(order);
        return savedOrder != null; // Return true if order is successfully processed
    }
  
    
    
    @ServiceActivator(inputChannel = "orderRequestChannel", outputChannel = "orderResponseChannel")
    public boolean processOrder(Message<OnlineOrder> message) {
        OnlineOrder order = message.getPayload();
        // Process the order (e.g., save to database)
        OnlineOrder savedOrder = orderRepository.save(order);
        return savedOrder != null; // Return true if order is successfully processed
    }
    
}
*/

