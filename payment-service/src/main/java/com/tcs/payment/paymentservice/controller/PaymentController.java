package com.tcs.payment.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.payment.paymentservice.model.Payment;
import com.tcs.payment.paymentservice.service.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/payment-service")
@RequiredArgsConstructor
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/order/{orderId}")
	public Payment getPaymentStatus(@PathVariable Long orderId) {

		return paymentService.getOrder(orderId);

	}


}
