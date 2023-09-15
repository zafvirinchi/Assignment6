package com.tcs.user.usermanagement.model;

public record CreateOrderResponse(Long userId, Long orderId, String orderStatus, Long productId, Integer quantity) {

}
