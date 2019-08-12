package com.payments.domain.sort.payments.columns;

import com.payments.domain.payment_way.Payment;
import com.payments.domain.sort.TypeOrder;

import java.util.Comparator;

/**
 * An class comparator for amount.
 */
public class AmountComparator implements Comparator<Payment> {
    private TypeOrder typeOrder;

    public AmountComparator(TypeOrder typeOrder) {
        this.typeOrder = typeOrder;
    }

    @Override
    public int compare(Payment paymentOne, Payment paymentTwo) {
        if(this.typeOrder == TypeOrder.DESC) {
            return paymentTwo.getAmount().compareTo(paymentOne.getAmount());
        }
        return paymentOne.getAmount().compareTo(paymentTwo.getAmount());
    }
}
