package com.tcs.payment.paymentservice.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.payment.paymentservice.entity.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

	public Optional<PaymentEntity> findByOrderId(Long orderId);

}