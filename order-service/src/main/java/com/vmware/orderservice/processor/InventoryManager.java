package com.vmware.orderservice.processor;

import org.springframework.stereotype.Component;
import org.springframework.integration.annotation.ServiceActivator;


@Component
public class InventoryManager {
	
	private Long processingDelay = 4000L;

	@ServiceActivator(inputChannel="inventoryProcessor")
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
    }
}