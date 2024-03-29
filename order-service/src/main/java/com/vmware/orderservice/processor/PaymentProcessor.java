package com.vmware.orderservice.processor;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class PaymentProcessor {
	
	private Long paymentDelay = 2000L;

    @RabbitListener(queues = OrderProcessingConfig.PAYMENT_QUEUE)
    public void processPayment(String orderId) {
        // Process payment logic for the order
        //System.out.println("Payment processed for order: " + orderId);
    	
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