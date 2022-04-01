package com.nisumdemoproject.paymentservice.service;

import com.nisumdemoproject.paymentservice.dto.PaymentDto;
import com.nisumdemoproject.paymentservice.entity.Payment;
import com.nisumdemoproject.paymentservice.repository.PaymentRepository;
import com.nisumdemoproject.paymentservice.utils.AppUtils;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    private static final Logger LOGGER = LoggerFactory.logger(PaymentService.class);

    @Autowired
    private PaymentRepository repository;

    public Payment doPayment(Payment payment){
        LOGGER.trace("***** doPayment Service Is Called *****");
        LOGGER.info("***** payment status saved Successfully *****");
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        LOGGER.info("***** Unique transaction id is generated for payment status *****");
        return repository.save(payment);
    }

    public String paymentProcessing(){
        LOGGER.info("***** paymentProcessing called *****");
        return new Random().nextBoolean()?"success":"false";
    }

    public Optional<PaymentDto> getPaymentByPaymentId(Integer id){
        LOGGER.trace("***** getPaymentByPaymentId Service Is Called *****");
        return repository.findById(id).map(AppUtils::entityToDto);
    }

    public Mono<Void> deletePaymentById(Integer id){
        LOGGER.trace("***** deletePaymentById Service Is Called *****");
        repository.deleteById(id);
        LOGGER.info("***** payment deleted Successfully *****");
        return null;
    }
}
