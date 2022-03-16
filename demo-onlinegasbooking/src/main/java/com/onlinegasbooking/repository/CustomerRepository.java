package com.onlinegasbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinegasbooking.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
 

}
