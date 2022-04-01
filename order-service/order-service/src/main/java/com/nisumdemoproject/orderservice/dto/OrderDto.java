package com.nisumdemoproject.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private int id;
    private String name;
    private int quantity;
    private double price;
}
