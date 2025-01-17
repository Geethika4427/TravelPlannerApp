package com.excelr.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excelr.model.PaymentRequest;

public interface PaymentRepository extends JpaRepository<PaymentRequest, Long> {

}
