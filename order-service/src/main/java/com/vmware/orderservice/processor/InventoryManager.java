package com.vmware.orderservice.processor;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class InventoryManager {
	
	private Long processingDelay = 4000L;

    @RabbitListener(queues = OrderProcessingConfig.INVENTORY_QUEUE)
    public void manageInventory(String orderId) {
        // Manage inventory logic for the order
    	try {
			Thread.sleep(this.processingDelay);
			System.out.println(Thread.currentThread().getName()
					+ " Inventory managed for order #"
					+ orderId);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
        // System.out.println("Inventory managed for order: " + orderId);
    }
}