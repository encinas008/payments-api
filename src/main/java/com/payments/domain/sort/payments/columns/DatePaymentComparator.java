package com.payments.domain.sort.payments.columns;

import com.payments.domain.payment_way.Payment;
import com.payments.domain.sort.TypeOrder;

import java.util.Comparator;

/**
 * An class comparator for date of payment.
 */
public class DatePaymentComparator implements Comparator<Payment> {
    private TypeOrder typeOrder;

    public DatePaymentComparator(TypeOrder typeOrder) {
        this.typeOrder = typeOrder;
    }

    @Override
    public int compare(Payment paymentOne, Payment paymentTwo) {
        if(this.typeOrder == TypeOrder.DESC) {
            return paymentTwo.getDatePayment().compareTo(paymentOne.getDatePayment());
        }
        return paymentOne.getDatePayment().compareTo(paymentTwo.getDatePayment());
    }
}
