package com.tcs.user.usermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tcs.user.usermanagement.entity.UserEntity;
import com.tcs.user.usermanagement.model.CreateOrder;
import com.tcs.user.usermanagement.model.CreateOrderResponse;
import com.tcs.user.usermanagement.model.GetOrder;
import com.tcs.user.usermanagement.model.Product;
import com.tcs.user.usermanagement.model.User;
import com.tcs.user.usermanagement.repo.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	@Autowired
	private UserRepository productRepository;

	@Autowired
	private RestTemplate restTemplate;

	private static final String PRODUCT_SERVICE_URL = "http://localhost:8086/v1/product-service";

	private static final String ORDER_SERVICE_URL = "http://localhost:8085/v1/order-service";

	public User createUser(User user) {

		UserEntity userEntity = new UserEntity();
		userEntity.setName(user.name());
		userEntity.setEmail(user.email());

		UserEntity createdUser = productRepository.save(userEntity);

		return new User(createdUser.getId(), createdUser.getName(), createdUser.getEmail());

	}

	public User updateUser(User user) {

		Long userId = user.id();
		UserEntity userEntity = productRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User with id " + userId + " does not exist."));

		userEntity.setId(userId);
		userEntity.setName(user.name());
		userEntity.setEmail(user.email());

		var createdUser = productRepository.save(userEntity);

		return new User(createdUser.getId(), createdUser.getName(), createdUser.getEmail());

	}

	public List<Product> getAllProducts() {

		var entity = new HttpEntity<Object>(null);

		var products = restTemplate.exchange(PRODUCT_SERVICE_URL + "/product", HttpMethod.GET, entity,
				new ParameterizedTypeReference<List<Product>>() {
				});

		return products.getBody();
	}

	public CreateOrderResponse createOrder(CreateOrder order) {

		return restTemplate.postForObject(ORDER_SERVICE_URL + "/order", order, CreateOrderResponse.class);

	}

}
