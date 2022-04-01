package com.nisumdemoproject.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.*;

@Entity
@Table(name = "ORDER_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    private int id;

    @NotEmpty
    @Size(min = 3, max = 20, message = "Order Name Must Have At list Three Character")
    private String name;

    private int quantity;
    private double price;

}
