package com.nisumdemoproject.orderservice.mapper;
import com.nisumdemoproject.orderservice.dto.OrderDto;
import com.nisumdemoproject.orderservice.entity.Order;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.UUID;


@Mapper(imports = UUID.class)
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source = "order.name",target = "name", defaultValue = "Order")
    @Mapping(target = "productId",expression = "java(UUID.randomUUID().toString())")
    OrderDto modelToDto(Order order);

    @InheritInverseConfiguration
    Order dtoToModel(OrderDto orderDto );


}
