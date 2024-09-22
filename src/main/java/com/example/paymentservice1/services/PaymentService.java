package com.example.paymentservice1.services;

public interface PaymentService {
    String createPaymentLink(long orderId) throws Exception;
}
