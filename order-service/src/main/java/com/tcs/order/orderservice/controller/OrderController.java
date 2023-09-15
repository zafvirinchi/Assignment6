package com.tcs.order.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.order.orderservice.model.Order;
import com.tcs.order.orderservice.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/order-service")
@RequiredArgsConstructor
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/order/{id}")
	public Order getOrder(@PathVariable Long id) {

		return orderService.getOrder(id);

	}


}
