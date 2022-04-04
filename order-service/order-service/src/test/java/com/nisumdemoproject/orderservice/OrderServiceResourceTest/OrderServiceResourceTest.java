package com.nisumdemoproject.orderservice.OrderServiceResourceTest;
import com.nisumdemoproject.orderservice.dto.OrderDto;
import com.nisumdemoproject.orderservice.service.OrderService;
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
@WebFluxTest(OrderServiceResource.class)
public class OrderServiceResourceTest {

      @Autowired
      WebTestClient webTestClient;

      @MockBean
      OrderService service;

      @Test
      public void getOrderByIdTest(){
          Optional<OrderDto> orderDtoOptional = Optional.of(new OrderDto(101,"mobile",1,545.0,"1234"));
          when(service.getOrder(any())).thenReturn(orderDtoOptional);

          Flux<OrderDto> responseBody = webTestClient.get().uri("/order/101")
                  .exchange()
                  .expectStatus().isOk()
                  .returnResult(OrderDto.class)
                  .getResponseBody();

          StepVerifier.create(responseBody)
                  .expectSubscription()
                  .expectNextMatches(p ->p.getName().equals("mobile"))
                  .verifyComplete();
      }

      @Test
      public void deleteOrderTest(){
          given(service.deleteOrderById(any())).willReturn(Mono.empty());
                   webTestClient.delete().uri("/order/delete/102")
                  .exchange()
                  .expectStatus().isOk();
  }
}
