package com.nisumdemoproject.orderservice.service;

import com.nisumdemoproject.orderservice.common.Payment;
import com.nisumdemoproject.orderservice.common.TransactionRequest;
import com.nisumdemoproject.orderservice.common.TransactionResponse;
import com.nisumdemoproject.orderservice.dto.OrderDto;
import com.nisumdemoproject.orderservice.entity.Order;
import com.nisumdemoproject.orderservice.repository.OrderRepository;

import com.nisumdemoproject.orderservice.utils.AppUtils;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;


@Service
public class OrderService {

    private static final Logger LOGGER = LoggerFactory.logger(OrderService.class);

    @Autowired
    private OrderRepository repository;

    @Autowired
    RestTemplate template;

    public TransactionResponse saveOrder(TransactionRequest request){
        LOGGER.trace("***** saveOrder Service Is Called *****");

        String response = "";
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

        LOGGER.info("****** Payment Rest API Calling ******");
        Payment paymentResponse = template.postForObject("http://localhost:9797/payment/doPayment",payment,Payment.class);
        response = paymentResponse.getPaymentStatus().equals("success")?"payment processing successful and order placed":"there is a failure in payment api order added to cart";

        repository.save(order);
        LOGGER.info("***** Order saved Successfully *****");
        return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);

    }


    /*public Flux<OrderDto> getOrderInRange(double min, double max){
        return repository.findByPriceBetween(Range.closed(min,max));
    }*/

    public Optional<OrderDto> getOrder(Integer id){
        LOGGER.trace("***** getOrder Service Is Called *****");
        LOGGER.info("***** Order Found By Id *****");
        return repository.findById(id).map(AppUtils::entityToDto);
    }
   

    public Mono<Void> deleteOrderById(Integer id){
        LOGGER.trace("***** deleteOrderById Service Is Called *****");
        repository.deleteById(id);
        LOGGER.info("***** Order Deleted By Id *****");
        return null;
    }

}
