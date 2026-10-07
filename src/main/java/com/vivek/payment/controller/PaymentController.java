package com.vivek.payment.controller;

import com.vivek.payment.entity.Payment;
import com.vivek.payment.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payments/{id}")
    public ResponseEntity<Payment> getPaymentDetails(@PathVariable long id){
        return ResponseEntity.ok(paymentService.getPaymentById(id));

    }
}
