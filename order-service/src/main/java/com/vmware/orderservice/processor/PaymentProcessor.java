package com.vmware.orderservice.processor;

import org.springframework.stereotype.Component;
import org.springframework.integration.annotation.ServiceActivator;



@Component
public class PaymentProcessor {
	
	private Long paymentDelay = 2000L;

	@ServiceActivator(inputChannel="paymentCredit")
    public void processPayment(String orderId) {
        // Process payment logic for the order    	
    	try {
			Thread.sleep(this.paymentDelay);
			System.out.println(Thread.currentThread().getName()
					+ " Payment processed for order #"
					+ orderId);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
    }
}