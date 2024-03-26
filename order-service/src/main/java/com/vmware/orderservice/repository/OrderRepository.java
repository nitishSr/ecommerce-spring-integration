package com.vmware.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vmware.orderservice.model.OnlineOrder;

public interface OrderRepository extends JpaRepository<OnlineOrder, Long> {
}