/*package com.vmware.orderservice.integration;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
//import org.springframework.integration.annotation.EnableIntegration;


//@EnableIntegration
public interface OrderIntegrationChannels {
    String ORDER_REQUEST_CHANNEL = "orderRequestChannel";
    String ORDER_RESPONSE_CHANNEL = "orderResponseChannel";


    SubscribableChannel orderRequestChannel();


    MessageChannel orderResponseChannel();
}


@EnableBinding(OrderIntegrationChannels.Binding.class)
public class OrderIntegrationChannels {

    public interface Binding {
        @Output("orderInput")
        MessageChannel orderInput();

        @Input("orderProcessed")
        SubscribableChannel orderProcessed();
    }
}
*/