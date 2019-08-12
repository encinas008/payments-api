package com.payments.domain.sort.payments.columns;

import com.payments.domain.payment_way.Check;
import com.payments.domain.payment_way.Payment;
import com.payments.domain.sort.TypeOrder;

import java.util.Comparator;

/**
 * An class comparator for check number.
 */
public class CheckNumberComparator implements Comparator<Payment> {
    private TypeOrder typeOrder;

    public CheckNumberComparator(TypeOrder typeOrder) {
        this.typeOrder = typeOrder;
    }

    @Override
    public int compare(Payment paymentOne, Payment paymentTwo) {
        if(paymentOne instanceof Check && paymentTwo instanceof Check) {
            if(this.typeOrder == TypeOrder.DESC) {
                return ((Check)paymentTwo).getCheckNumber().compareTo(((Check)paymentOne).getCheckNumber());
            }
            return ((Check)paymentOne).getCheckNumber().compareTo(((Check)paymentTwo).getCheckNumber());
        }
        return 0;
    }
}
