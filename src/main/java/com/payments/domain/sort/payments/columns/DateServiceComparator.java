package com.payments.domain.sort.payments.columns;

import com.payments.domain.payment_way.Payment;
import com.payments.domain.sort.TypeOrder;

import java.util.Comparator;

/**
 * An class comparator for date service.
 */
public class DateServiceComparator implements Comparator<Payment> {
    private TypeOrder typeOrder;

    public DateServiceComparator(TypeOrder typeOrder) {
        this.typeOrder = typeOrder;
    }

    @Override
    public int compare(Payment paymentOne, Payment paymentTwo) {
        if(this.typeOrder == TypeOrder.DESC) {
            return paymentTwo.getDateService().compareTo(paymentOne.getDateService());
        }
        return paymentOne.getDateService().compareTo(paymentTwo.getDateService());
    }
}
