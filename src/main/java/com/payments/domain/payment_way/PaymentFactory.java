package com.payments.domain.payment_way;

import org.springframework.stereotype.Service;

/**
 * An class factory to create payments.
 */
@Service
public class PaymentFactory {
    public Payment getTypePayment(String type) {
        Payment payment = null;
        switch (type) {
            case "CHECK":
                payment = new Check();
                break;
            case "CASH":
                payment = new Cash();
                break;
            case "CARD":
                payment = new Card();
                break;
            case "TRANSFER":
                payment = new Transfer();
                break;
        }
        return payment;
    }
}
