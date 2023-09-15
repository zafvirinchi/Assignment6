package com.tcs.user.usermanagement.model;

public record GetOrder(Long orderId, Integer quantity, String status, Product product) {

}
