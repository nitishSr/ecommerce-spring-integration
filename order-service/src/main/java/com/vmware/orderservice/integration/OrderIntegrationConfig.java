/*package com.vmware.orderservice.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.config.EnableIntegration;

import com.vmware.orderservice.integration.OrderIntegrationChannels;
import com.vmware.orderservice.service.OrderService;
import com.vmware.orderservice.model.OnlineOrder;

import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.scheduling.PollerMetadata;

/*@Configuration
@EnableIntegration
@IntegrationComponentScan
public class OrderIntegrationConfig {
    @Bean
    public DirectChannel orderRequestChannel() {
        return new DirectChannel();
    }

    @Bean
    public DirectChannel orderResponseChannel() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow orderFlow(OrderIntegrationChannels channels, OrderService orderService) {
        return IntegrationFlow.from(channels.orderRequestChannel())
                .handle(orderService, "processOrder")
                .channel(channels.orderResponseChannel())
                .get();
    }
}
*/

/*@Configuration
public class OrderIntegrationConfig {

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata poller() {
        return Pollers.fixedRate(1000).get();
    }

    @Bean
    public IntegrationFlow processOrder(OrderService orderService, OrderIntegrationChannels channels) {
        return IntegrationFlows.from(channels.orderInput())
                .handle(orderService, "processOrder")
                .get();
    }
}
*/