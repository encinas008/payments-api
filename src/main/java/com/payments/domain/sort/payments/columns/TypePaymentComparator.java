package com.payments.domain.sort.payments.columns;

import com.payments.domain.payment_way.Payment;
import com.payments.domain.sort.TypeOrder;

import java.util.Comparator;

/**
 * An class comparator for type of payment.
 */
public class TypePaymentComparator implements Comparator<Payment> {
    private TypeOrder typeOrder;

    public TypePaymentComparator(TypeOrder typeOrder) {
        this.typeOrder = typeOrder;
    }

    @Override
    public int compare(Payment paymentOne, Payment paymentTwo) {
        if(this.typeOrder == TypeOrder.DESC) {
            return paymentTwo.getTypePayment().compareTo(paymentOne.getTypePayment());
        }
        return paymentOne.getTypePayment().compareTo(paymentTwo.getTypePayment());
    }
}
