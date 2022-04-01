package com.nisumdemoproject.paymentservice.controller;

import com.nisumdemoproject.paymentservice.dto.PaymentDto;
import com.nisumdemoproject.paymentservice.entity.Payment;
import com.nisumdemoproject.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Optional;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;


@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment){
        LOGGER.info("****** doPayment Action Called.....******");
        return service.doPayment(payment);
    }

    @GetMapping("/{id}")
    public Optional<PaymentDto> getPaymentById(@PathVariable Integer id){
        LOGGER.info("****** getPaymentById Action Called.....******");
        return service.getPaymentByPaymentId(id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deletePaymentById(@PathVariable Integer id){
        LOGGER.info("****** deletePaymentById Action Called.....******");
        return service.deletePaymentById(id);
    }
}
