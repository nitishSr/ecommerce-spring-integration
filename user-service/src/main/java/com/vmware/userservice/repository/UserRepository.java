package com.vmware.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vmware.userservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}