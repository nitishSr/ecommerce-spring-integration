package com.vmware.orderservice.processor;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderProcessingConfig {

    public static final String ORDER_DIRECT_EXCHANGE = "order-direct-exchange";
    public static final String PAYMENT_QUEUE = "payment-queue";
    public static final String INVENTORY_QUEUE = "inventory-queue";
    public static final String SHIPPING_QUEUE = "shipping-queue";

    // Routing keys for different order processing stages
    public static final String ROUTING_KEY_PAYMENT = "payment";
    public static final String ROUTING_KEY_INVENTORY = "inventory";
    public static final String ROUTING_KEY_SHIPPING = "shipping";

    @Bean
    public DirectExchange orderDirectExchange() {
        return new DirectExchange(ORDER_DIRECT_EXCHANGE);
    }

    @Bean
    public Queue paymentQueue() {
        return new Queue(PAYMENT_QUEUE);
    }

    @Bean
    public Queue inventoryQueue() {
        return new Queue(INVENTORY_QUEUE);
    }

    @Bean
    public Queue shippingQueue() {
        return new Queue(SHIPPING_QUEUE);
    }

    @Bean
    public Binding paymentBinding() {
        return BindingBuilder.bind(paymentQueue()).to(orderDirectExchange()).with(ROUTING_KEY_PAYMENT);
    }

    @Bean
    public Binding inventoryBinding() {
        return BindingBuilder.bind(inventoryQueue()).to(orderDirectExchange()).with(ROUTING_KEY_INVENTORY);
    }

    @Bean
    public Binding shippingBinding() {
        return BindingBuilder.bind(shippingQueue()).to(orderDirectExchange()).with(ROUTING_KEY_SHIPPING);
    }
}