package com.nisumdemoproject.orderservice.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    @Id
    private int id;
    private String name;
    private int quantity;
    private double price;
    private String productId;
}
