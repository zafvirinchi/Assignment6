package com.tcs.order.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.order.orderservice.model.Order;
import com.tcs.order.orderservice.repo.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public Order getOrder(Long id) {

		var orderDetails = orderRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Order with id " + id + " does not exist."));

		return new Order(id, orderDetails.getName(), orderDetails.getPrice());

	}

}
