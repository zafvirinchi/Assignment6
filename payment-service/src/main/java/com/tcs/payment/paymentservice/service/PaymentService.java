package com.tcs.payment.paymentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.payment.paymentservice.entity.PaymentEntity;
import com.tcs.payment.paymentservice.model.Payment;
import com.tcs.payment.paymentservice.repo.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	public Payment getOrder(Long orderId) {

		PaymentEntity paymentEntity = paymentRepository.findByOrderId(orderId).orElseThrow(
				() -> new RuntimeException("Payment details for the orderId " + orderId + " does not exist."));

		return new Payment(orderId, paymentEntity.getStatus());

	}

}
