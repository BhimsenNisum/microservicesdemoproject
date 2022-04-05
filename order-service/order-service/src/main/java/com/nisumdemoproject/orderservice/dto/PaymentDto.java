package com.nisumdemoproject.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    private int paymentId;
    private String paymentStatus;
    private String transactionId;
    private int orderId;
    private double amount;
}
