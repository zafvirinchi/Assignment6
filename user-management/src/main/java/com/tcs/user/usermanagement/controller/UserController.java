package com.tcs.user.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.user.usermanagement.model.CreateOrder;
import com.tcs.user.usermanagement.model.CreateOrderResponse;
import com.tcs.user.usermanagement.model.GetOrder;
import com.tcs.user.usermanagement.model.Product;
import com.tcs.user.usermanagement.model.User;
import com.tcs.user.usermanagement.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/user-service/")
@RequiredArgsConstructor
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user")
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@RequestBody User user) {

		return userService.createUser(user);

	}

	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {

		return userService.updateUser(user);

	}

	@GetMapping("/product")
	public List<Product> getAllProducts() {

		return userService.getAllProducts();
	}

	@PostMapping("/order")
	@ResponseStatus(HttpStatus.CREATED)
	public CreateOrderResponse createOrder(@RequestBody CreateOrder order) {

		return userService.createOrder(order);

	}
	

}
