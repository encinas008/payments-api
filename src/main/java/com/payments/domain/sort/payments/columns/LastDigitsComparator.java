package com.payments.domain.sort.payments.columns;

import com.payments.domain.payment_way.Card;
import com.payments.domain.payment_way.Payment;
import com.payments.domain.sort.TypeOrder;

import java.util.Comparator;

/**
 * An class comparator for digits of card.
 */
public class LastDigitsComparator implements Comparator<Payment> {
    private TypeOrder typeOrder;

    public LastDigitsComparator(TypeOrder typeOrder) {
        this.typeOrder = typeOrder;
    }

    @Override
    public int compare(Payment paymentOne, Payment paymentTwo) {
        if(paymentOne instanceof Card && paymentTwo instanceof Card) {
            if(this.typeOrder == TypeOrder.DESC) {
                return ((Card) paymentTwo).getLastDigits().compareTo(((Card) paymentOne).getLastDigits());
            }
            return ((Card) paymentOne).getLastDigits().compareTo(((Card) paymentTwo).getLastDigits());
        }
        return 0;
    }
}
