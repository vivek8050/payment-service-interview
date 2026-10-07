package com.vivek.payment.service;

import com.vivek.payment.repository.PaymentRepository;
import com.vivek.payment.entity.Payment;
import com.vivek.payment.exception.PaymentNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    public Payment getPaymentById(Long id) {
        // your code
        return paymentRepository.findById(id).orElseThrow(()->new PaymentNotFoundException(id));
    }
}
