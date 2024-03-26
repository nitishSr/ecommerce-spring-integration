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

/*
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