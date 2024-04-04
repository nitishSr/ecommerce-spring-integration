package com.vmware.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitTemplateConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mapping.model.DefaultSpELExpressionEvaluator;
import org.springframework.stereotype.Service;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.integration.annotation.Router;
import org.springframework.messaging.MessageChannel;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.Splitter;
import org.springframework.integration.router.RecipientListRouter;
import com.vmware.orderservice.integration.OrderIntegrationConfig;

import java.util.List;
import com.vmware.orderservice.repository.OrderRepository;
import com.vmware.orderservice.model.OnlineOrder;
import com.vmware.orderservice.processor.InventoryManager;
import com.vmware.orderservice.processor.PaymentProcessor;
import com.vmware.orderservice.processor.ShippingHandler;
import com.vmware.orderservice.integration.OrderIntegrationConfig.OrderGateway;


@MessageEndpoint
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private OrderIntegrationConfig orderIntegrationConfig;
    
    private final OrderGateway orderGateway;

    @Autowired
    public OrderService(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }
    
    private <T> Message<T> message(T val) {
        return org.springframework.messaging.support.MessageBuilder.withPayload(val).build();
    }
    
    public List<OnlineOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    public boolean processOrder(OnlineOrder order) {
        // Process the order (e.g., save to database)
        OnlineOrder savedOrder = orderRepository.save(order);
        
        System.out.println("Initiating order processing for order id : "+order.getId());
        System.out.println("Saved new order to db with order id : "+order.getId());
        
        orderGateway.sendOrder(order);
        //routeOrder(order);        
        return savedOrder != null; // Return true if order is successfully processed
    }
    
    @ServiceActivator(inputChannel = "orderRequestChannel")
    public void routeOrder(OnlineOrder order) {
    	processOrderPayment(order.getId());
        processOrderInventory(order.getId());
        processOrderShipping(order.getId());
    }
    

    public void processOrderPayment(Long orderId) {
        // Simulate processing payment and send order to the payment queue
    	System.out.println("Forwarded order to payment processsor");
    	orderIntegrationConfig.paymentCredit().send(message(orderId));
    }

    
    public void processOrderInventory(Long orderId) {
        // Simulate managing inventory and send order to the inventory queue
    	System.out.println("Forwarded order to inventory processsor");
    	orderIntegrationConfig.inventoryProcessor().send(message(orderId));
    }

    public void processOrderShipping(Long orderId) {
        // Simulate shipping and send order to the shipping queue
    	System.out.println("Forwarded order to shipping processsor");
    	orderIntegrationConfig.shippingProcessor().send(message(orderId));
    }   
}


