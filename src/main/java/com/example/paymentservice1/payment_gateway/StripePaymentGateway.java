package com.example.paymentservice1.payment_gateway;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.param.PaymentLinkCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StripePaymentGateway implements PaymentGatewayInterface{
    @Value("${stripe.secret.key}")
    private String sripeSecretKey;
    @Override
    public String createPaymentLink(long orderId, long amount) throws StripeException {
        //We are going to call stripe to do our payment
        Stripe.apiKey = sripeSecretKey;
        //product id will be received from order service
        //given product id , fetch its price from stripe
        PaymentLinkCreateParams params =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice("price_1Q0hMtP419McT5y6Mm7r9DBe")
                                        .setQuantity(1L)
                                        .build()
                        )
                        .setAfterCompletion(PaymentLinkCreateParams.AfterCompletion.builder()
                                .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                .setRedirect(PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                        .setUrl("https://scaler.com")
                                        .build()
                                ).build()
                        )
                        .build();

        PaymentLink paymentLink = PaymentLink.create(params);
        return paymentLink.getUrl();
    }
}


