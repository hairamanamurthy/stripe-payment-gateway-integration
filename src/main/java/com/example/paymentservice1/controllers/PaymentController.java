package com.example.paymentservice1.controllers;

import com.example.paymentservice1.dtos.CreatePaymentLinkRequestDto;
import com.example.paymentservice1.dtos.CreatePaymentLinkResponseDto;
import com.example.paymentservice1.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/paymentlink")
    public ResponseEntity<CreatePaymentLinkResponseDto> createPaymentLink(@RequestBody CreatePaymentLinkRequestDto requestDto) {

        try {
           String url= paymentService.createPaymentLink(requestDto.getOrderId());
            CreatePaymentLinkResponseDto responseDto=new CreatePaymentLinkResponseDto();
            responseDto.setUrl(url);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
}
