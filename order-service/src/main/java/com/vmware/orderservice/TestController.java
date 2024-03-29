package com.vmware.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vmware.orderservice.model.OnlineOrder;
import com.vmware.orderservice.service.OrderService;

@RestController
public class TestController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/test/place-order")
    public String placeOrder(@RequestBody OnlineOrder order) {
    	System.out.println("Recieved new order ...");
        boolean orderPlaced = orderService.processOrder(order);
        return orderPlaced ? "Order placed successfully!" : "Failed to place order!";
    }
}
