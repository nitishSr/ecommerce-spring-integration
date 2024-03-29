/*package com.vmware.orderservice.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import com.vmware.orderservice.model.OnlineOrder;

@EnableBinding(OrderIntegrationChannels.Binding.class)
public class OrderProcessor {

    @StreamListener("orderProcessed")
    public void processOrder(OnlineOrder order) {
        // Process the order and notify on completion
        System.out.println("Order processed: " + order);
    }
}
*/