package com.vmware.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vmware.orderservice.model.OnlineOrder;
import com.vmware.orderservice.repository.OrderRepository;
import com.vmware.orderservice.service.OrderService;
//import com.vmware.orderservice.integration.OrderIntegrationChannels;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/* for using REST API calls
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/")
    public List<OnlineOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    @PostMapping("/")
    public OnlineOrder addOrder(@RequestBody OnlineOrder order) {
        return orderRepository.save(order);
    }
}
*/

/* for using HTML template call */
@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public String getProductOrdersFromUsers(Model model) {
        model.addAttribute("onlineorders", orderService.getAllOrders());
        return "onlineorders"; // Thymeleaf HTML template name without extension
    }
}


/*@RestController
public class OrderController {

    @Autowired
    private OrderIntegrationChannels channels;

    @PostMapping("/place-order")
    public String placeOrder(@RequestBody OnlineOrder order) {
        // Create a message with the order payload
        Message<OnlineOrder> message = MessageBuilder.withPayload(order).build();
        
        // Send the message to the order request channel
        MessageChannel requestChannel = channels.orderRequestChannel();
        boolean orderPlaced = requestChannel.send(message);

        return orderPlaced ? "Order placed successfully!" : "Failed to place order!";
    }
}
*/

/*
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    @GetMapping("/")
    public List<OnlineOrder> getAllOrders() {
        return orderService.getAllOrders();
    }
    
    @PostMapping("/order")
    public String placeOrder(@RequestBody OnlineOrder order) {
        orderService.processOrder(order);
        return "Order placed successfully!";
    }
}
*/

