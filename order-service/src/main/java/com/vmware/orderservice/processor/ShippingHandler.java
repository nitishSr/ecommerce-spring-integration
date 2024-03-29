package com.vmware.orderservice.processor;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ShippingHandler {
	
	private Long shippingDelay = 7000L;

    @RabbitListener(queues = OrderProcessingConfig.SHIPPING_QUEUE)
    public void handleShipping(String orderId) {
        // Handle shipping logic for the order
        // System.out.println("Order shipped: " + orderId);
    	
    	try {
			Thread.sleep(this.shippingDelay);
			System.out.println(Thread.currentThread().getName()
					+ " Shipping done for order #"
					+ orderId);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
    }
}