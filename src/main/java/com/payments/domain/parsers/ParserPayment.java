package com.payments.domain.parsers;

import com.payments.domain.dtos.PaymentDto;
import com.payments.domain.payment_way.Payment;
import com.payments.domain.payment_way.PaymentFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class to convert paymentDto to Payment
 */
@Service
public class ParserPayment {
    public Payment paymentDtoToPayment(PaymentDto paymentDto, Payment payment) {
        BeanUtils.copyProperties(paymentDto, payment);
        return payment;
    }
}
