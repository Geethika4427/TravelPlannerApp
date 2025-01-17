//package com.excelr.controller;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.excelr.model.PaymentRequest;
//
//@RestController
//@RequestMapping("/api/payments")
//public class PaymentController {
//
//    @PostMapping("/create")
//    public ResponseEntity<?> createPayment(@RequestBody PaymentRequest paymentRequest) {
//        // Validate card number format (mock validation)
//        if (paymentRequest.getCardNumber() == null || !paymentRequest.getCardNumber().matches("\\d{16}")) {
//            return ResponseEntity.badRequest().body("Invalid card number. Please provide a valid 16-digit card number.");
//        }
//
//        // Validate expiry date format (MM/YY)
//        if (paymentRequest.getExpiryDate() == null || !paymentRequest.getExpiryDate().matches("(0[1-9]|1[0-2])/(\\d{2})")) {
//            return ResponseEntity.badRequest().body("Invalid expiry date. Please provide in MM/YY format.");
//        }
//
//        // Validate CVV (3-digit numeric)
//        if (paymentRequest.getCvv() == null || !paymentRequest.getCvv().matches("\\d{3}")) {
//            return ResponseEntity.badRequest().body("Invalid CVV. Please provide a 3-digit CVV.");
//        }
//
//        // Validate amount
//        if (paymentRequest.getAmount() <= 0) {
//            return ResponseEntity.badRequest().body("Invalid amount. Please provide a positive amount.");
//        }
//
//        // Simulate a payment token
//        String paymentToken = "mock_payment_token_" + System.currentTimeMillis();
//        return ResponseEntity.ok().body("Payment token generated: " + paymentToken);
//    }
//
////    @PostMapping("/confirm")
////    public ResponseEntity<?> confirmPayment(@RequestParam String token) {
////        // Validate payment token format
////        if (token == null || !token.startsWith("mock_payment_token_")) {
////            return ResponseEntity.badRequest().body("Invalid or missing payment token. Please provide a valid token.");
////        }
////
////        // Simulate payment confirmation
////        return ResponseEntity.ok().body("Payment successfully confirmed for token: " + token);
////    }
//    
//    
//    @PostMapping("/confirm")
//    public ResponseEntity<?> confirmPayment(@RequestParam String token) {
//        // Validate payment token format
//        if (token == null || !token.startsWith("mock_payment_token_")) {
//            return ResponseEntity.badRequest().body("Invalid or missing payment token. Please provide a valid token.");
//        }
//
//        // Simulate payment confirmation
//        return ResponseEntity.ok().body("Payment successfully confirmed.");
//    }
//
//}
//
//
//


package com.excelr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.excelr.model.PaymentRequest;
import com.excelr.repo.PaymentRepository;


@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createPayment(@RequestBody PaymentRequest paymentRequest) {
        // Validate card number format (mock validation)
        if (paymentRequest.getCardNumber() == null || !paymentRequest.getCardNumber().matches("\\d{16}")) {
            return ResponseEntity.badRequest().body("Invalid card number. Please provide a valid 16-digit card number.");
        }

        // Validate expiry date format (MM/YY)
        if (paymentRequest.getExpiryDate() == null || !paymentRequest.getExpiryDate().matches("(0[1-9]|1[0-2])/(\\d{2})")) {
            return ResponseEntity.badRequest().body("Invalid expiry date. Please provide in MM/YY format.");
        }

        // Validate CVV (3-digit numeric)
        if (paymentRequest.getCvv() == null || !paymentRequest.getCvv().matches("\\d{3}")) {
            return ResponseEntity.badRequest().body("Invalid CVV. Please provide a 3-digit CVV.");
        }

        // Validate amount
        if (paymentRequest.getAmount() <= 0) {
            return ResponseEntity.badRequest().body("Invalid amount. Please provide a positive amount.");
        }

        // Save payment request to database
        paymentRepository.save(paymentRequest);

        // Simulate a payment token
        String paymentToken = "mock_payment_token_" + System.currentTimeMillis();
        return ResponseEntity.ok().body("Payment token generated: " + paymentToken);
    }

    @PostMapping("/confirm")
    public ResponseEntity<?> confirmPayment(@RequestParam String token) {
        // Validate payment token format
        if (token == null || !token.startsWith("mock_payment_token_")) {
            return ResponseEntity.badRequest().body("Invalid or missing payment token. Please provide a valid token.");
        }

        // Simulate payment confirmation
        return ResponseEntity.ok().body("Payment successfully confirmed.");
    }
}

