package com.tcs.order.orderservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.order.orderservice.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>{
	
	
}