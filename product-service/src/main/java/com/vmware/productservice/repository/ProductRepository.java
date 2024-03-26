package com.vmware.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vmware.productservice.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}