package com.example.paymentservice1.payment_gateway;

public class RazorPayPaymentGateway implements PaymentGatewayInterface{
    @Override
    public String createPaymentLink(long orderId, long amount) {
        return "";
    }
}
