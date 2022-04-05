package com.nisumdemoproject.orderservice.mapper;
import com.nisumdemoproject.orderservice.common.Payment;
import com.nisumdemoproject.orderservice.dto.PaymentDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMapper {

    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);


    PaymentDto modelToDto(Payment payment);

    @InheritInverseConfiguration
    Payment dtoToModel(PaymentDto paymentDto );
}
