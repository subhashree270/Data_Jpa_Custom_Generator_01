package com.subha.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subha.entity.Order;

public interface OrderRepo extends JpaRepository<Order,String>{

}
