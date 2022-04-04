package com.nisumdemoproject.orderservice.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.*;
import javax.persistence.*;

@Entity
@Table(name = "ORDER_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    private int id;

    @NotNull(message = "Order Name Should not be Null")
    @Size(min = 3, max = 20, message = "Order Name Must Have At list Three Character")
    private String name;

    @Min(1)
    @Max(5)
    private int quantity;

    @NotNull
    private double price;

    private String productId;

}
