package com.payments.domain.sort.payments.columns;

import com.payments.domain.payment_way.Payment;
import com.payments.domain.sort.TypeOrder;

import java.util.Comparator;

/**
 * An class comparator for concept.
 */
public class ConceptComparator implements Comparator<Payment> {
    private TypeOrder typeOrder;

    public ConceptComparator(TypeOrder typeOrder) {
        this.typeOrder = typeOrder;
    }

    @Override
    public int compare(Payment paymentOne, Payment paymentTwo) {
        if(this.typeOrder == TypeOrder.DESC) {
            return paymentTwo.getConcept().compareTo(paymentOne.getConcept());
        }
        return paymentOne.getConcept().compareTo(paymentTwo.getConcept());
    }
}
