package com.nisumdemoproject.orderservice.repository;


import com.nisumdemoproject.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order,Integer> {

    //Flux<OrderDto> findByPriceBetween(Range<Double> closed);
}
