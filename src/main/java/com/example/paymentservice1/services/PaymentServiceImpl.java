package com.example.paymentservice1.services;

import com.example.paymentservice1.payment_gateway.PaymentGatewayInterface;
import com.example.paymentservice1.payment_gateway.RazorPayPaymentGateway;
import com.example.paymentservice1.payment_gateway.StripePaymentGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentGatewayInterface pgi;

    @Override
    public String createPaymentLink(long orderId) throws Exception {
        long amount=1000;

        return pgi.createPaymentLink(orderId,amount);
    }
}
