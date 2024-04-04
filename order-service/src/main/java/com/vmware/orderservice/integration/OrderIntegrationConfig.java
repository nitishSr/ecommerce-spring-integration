package com.vmware.orderservice.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.integration.annotation.MessagingGateway;


import com.vmware.orderservice.service.OrderService;
import com.vmware.orderservice.model.OnlineOrder;

@Configuration
public class OrderIntegrationConfig {
	
	 @Bean
	 public MessageChannel orderRequestChannel() {
		 return new QueueChannel();
	 }
	 
	 @Bean
	 public MessageChannel paymentCredit() {
		 return new QueueChannel();
	 }
	 
	 @Bean
	 public MessageChannel inventoryProcessor() {
		 return new QueueChannel();
	 }
	 
	 @Bean
	 public MessageChannel shippingProcessor() {
		 return new QueueChannel();
	 }

	 @MessagingGateway(defaultRequestChannel = "orderRequestChannel")
	 public interface OrderGateway {
		 void sendOrder(OnlineOrder order);
	 }
	 
	 
}
