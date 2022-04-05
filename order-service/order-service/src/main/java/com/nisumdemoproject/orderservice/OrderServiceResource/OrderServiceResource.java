package com.nisumdemoproject.orderservice.OrderServiceResource;
import com.nisumdemoproject.orderservice.common.TransactionRequest;
import com.nisumdemoproject.orderservice.common.TransactionResponse;
import com.nisumdemoproject.orderservice.dto.OrderDto;
import com.nisumdemoproject.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import javax.validation.Valid;
import java.util.Optional;
import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@RestController
@RequestMapping("/order")
public class OrderServiceResource {

    @Autowired
    private OrderService service;

    @PostMapping("/saveOrder")
    public TransactionResponse bookOrder(@Valid @RequestBody TransactionRequest request){
        LOGGER.info("****** bookOrder Action Called.....******");
        LOGGER.info("****** Order Saved .....******");
        return service.saveOrder(request);
    }

    @GetMapping("/{id}")
    public Optional<OrderDto> getOrderById(@PathVariable Integer id){
        LOGGER.info("****** getOrderById Action Called.....******");
        return service.getOrder(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> deleteOrder(@PathVariable Integer id){
        LOGGER.info("****** deleteOrder Action Called.....******");
        LOGGER.info("****** Order Deleted by id .....******");
        return service.deleteOrderById(id);
    }
}
