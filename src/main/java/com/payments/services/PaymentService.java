package com.payments.services;

import com.payments.dal.FileStore;
import com.payments.domain.dtos.ColumnDto;
import com.payments.domain.dtos.PaymentDto;
import com.payments.domain.parsers.ParserPayment;
import com.payments.domain.payment_way.Payment;
import com.payments.domain.payment_way.PaymentFactory;
import com.payments.domain.sort.payments.PaymentComparatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

/**
 * Service to manage payments.
 */
@Service
public class PaymentService {
    @Autowired
    PaymentFactory paymentFactory;

    @Autowired
    ParserPayment parserPayment;

    @Autowired
    FileStore fileStore;

    /**
     * Creates a payment.
     * @param paymentDto An object that contain info about the payment.
     * @return An Payment.
     */
    public Payment createPayment(PaymentDto paymentDto) {
        Payment payment = paymentFactory.getTypePayment(paymentDto.getTypePayment());
        parserPayment.paymentDtoToPayment(paymentDto, payment);
        fileStore.save(payment);
        return payment;
    }

    /**
     * Gets an array of all payments
     * @return An array of payments.
     */
    public List<Payment> getAllPayments() {
        return fileStore.findAll();
    }

    /**
     * Gets an array of all payments order by DESC.
     * @return
     */
    public List<Payment> orderPayments(List<ColumnDto> listFields) {
        Comparator<Payment> comparator = new PaymentComparatorFactory(listFields).getPaymentComparator();
        List<Payment> payments = fileStore.findAll();
        payments.sort(comparator);
        return payments;
    }
}
