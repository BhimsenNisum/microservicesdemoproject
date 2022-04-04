package com.nisumdemoproject.paymentservice.service;
import com.nisumdemoproject.paymentservice.dto.PaymentDto;
import com.nisumdemoproject.paymentservice.entity.Payment;
import com.nisumdemoproject.paymentservice.repository.PaymentRepository;
import com.nisumdemoproject.paymentservice.utils.AppUtils;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@Slf4j
@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    public Payment doPayment(Payment payment){
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
        LOGGER.info("***** getPaymentByPaymentId Service Is Called *****");
        return repository.findById(id).map(AppUtils::entityToDto);
    }

    public Mono<Void> deletePaymentById(Integer id){
        LOGGER.info("***** deletePaymentById Service Is Called *****");
        repository.deleteById(id);
        LOGGER.info("***** payment deleted Successfully *****");
        return null;
    }
}
