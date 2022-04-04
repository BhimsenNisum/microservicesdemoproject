package com.nisumdemoproject.paymentservice.utils;
import com.nisumdemoproject.paymentservice.dto.PaymentDto;
import com.nisumdemoproject.paymentservice.entity.Payment;
import org.springframework.beans.BeanUtils;

public class AppUtils {
    public static PaymentDto entityToDto(Payment payment){
        PaymentDto paymentDto = new PaymentDto();
        BeanUtils.copyProperties(payment,paymentDto);
        return paymentDto;
    }

    public static Payment dtoToEntity(PaymentDto paymentDto){
        Payment payment = new Payment();
        BeanUtils.copyProperties(paymentDto,payment);
        return payment;
    }
}
