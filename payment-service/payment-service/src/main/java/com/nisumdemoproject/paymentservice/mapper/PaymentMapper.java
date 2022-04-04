package com.nisumdemoproject.paymentservice.mapper;
import com.nisumdemoproject.paymentservice.dto.PaymentDto;
import com.nisumdemoproject.paymentservice.entity.Payment;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMapper {
      PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

      @Mapping(source = "payment.paymentId",target = "paymentId",defaultValue = "PaymentId")
      PaymentDto modelToDto(Payment payment);

      @InheritInverseConfiguration
      Payment dtoToModel(PaymentDto paymentDto);
}
