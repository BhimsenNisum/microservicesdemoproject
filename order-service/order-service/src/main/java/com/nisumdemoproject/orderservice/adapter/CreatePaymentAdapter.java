package com.nisumdemoproject.orderservice.adapter;

import com.nisumdemoproject.orderservice.common.Payment;
import com.nisumdemoproject.orderservice.common.TransactionRequest;
import com.nisumdemoproject.orderservice.common.TransactionResponse;
import com.nisumdemoproject.orderservice.entity.Order;
import com.nisumdemoproject.orderservice.mapper.OrderMapper;
import com.nisumdemoproject.orderservice.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class CreatePaymentAdapter {

    @Autowired
    RestTemplate template;

    private OrderMapper orderMapper;
    private PaymentMapper paymentMapper;

    final static String url = "http://localhost:9797/payment/save";

    public TransactionResponse savePayment(TransactionRequest request){
        String response = "";
        Order order = (Order) orderMapper;
        Payment payment = (Payment) paymentMapper;
        Payment paymentResponse = template.postForObject(url,payment,Payment.class);
        response = paymentResponse.getPaymentStatus().equals("success")?"payment processing successful and order placed":"there is a failure in payment api order added to cart";
        return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
    }
}
