package com.nisumdemoproject.paymentservice.repository;

import com.nisumdemoproject.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
