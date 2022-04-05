package com.nisumdemoproject.paymentservice.PaymentServiceResource;

import com.nisumdemoproject.paymentservice.dto.PaymentDto;
import com.nisumdemoproject.paymentservice.service.PaymentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebFluxTest(PaymentServiceResource.class)
public class PaymentServiceResourceTest {

    @Autowired
    WebTestClient webTestClient;

    @MockBean
    PaymentService service;

    @Test
    public void getPaymentByIdTest(){
        Optional<PaymentDto> paymentDtoOptional = Optional.of(new PaymentDto(101,"success","1c4d20c5-1e95-45ec-893d-4f5dd7ac1548",22,22000));
        when(service.getPaymentByPaymentId(any())).thenReturn(paymentDtoOptional);

        Flux<PaymentDto> responseBody = webTestClient.get().uri("/payment/101")
                .exchange()
                .expectStatus().isOk()
                .returnResult(PaymentDto.class)
                .getResponseBody();

        StepVerifier.create(responseBody)
                .expectSubscription()
                .expectNextMatches(p ->p.getTransactionId().equals("1c4d20c5-1e95-45ec-893d-4f5dd7ac1548"))
                .verifyComplete();
    }

    @Test
    public void deletePaymentByIdTest(){
        given(service.deletePaymentById(any())).willReturn(Mono.empty());
        webTestClient.delete().uri("/payment/delete/101")
                .exchange()
                .expectStatus().isOk();

    }



}
