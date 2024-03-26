package com.vmware.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vmware.productservice.model.Product;
import com.vmware.productservice.repository.ProductRepository;
import com.vmware.productservice.service.ProductService;

/*
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/")
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
*/

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String getProductCatalog(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "productCatalog"; // Thymeleaf HTML template name without extension
    }
}


