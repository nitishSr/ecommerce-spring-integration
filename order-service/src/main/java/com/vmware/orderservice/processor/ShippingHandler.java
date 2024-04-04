package com.vmware.orderservice.processor;

import org.springframework.stereotype.Component;
import org.springframework.integration.annotation.ServiceActivator;

@Component
public class ShippingHandler {
	
	private Long shippingDelay = 7000L;

	@ServiceActivator(inputChannel="shippingProcessor")
    public void handleShipping(String orderId) {
        // Handle shipping logic for the order	
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