package com.vmware.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmware.userservice.model.User;
import com.vmware.userservice.repository.UserRepository;
import com.vmware.userservice.service.UserService;

/*
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/")
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
*/

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getUsersList(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users"; // Thymeleaf HTML template name without extension
    }
}