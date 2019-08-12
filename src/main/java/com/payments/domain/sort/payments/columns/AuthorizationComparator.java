package com.payments.domain.sort.payments.columns;

import com.payments.domain.payment_way.Card;
import com.payments.domain.payment_way.Payment;
import com.payments.domain.payment_way.Transfer;
import com.payments.domain.sort.TypeOrder;

import java.util.Comparator;

/**
 * An class comparator for authorization.
 */
public class AuthorizationComparator implements Comparator<Payment> {
    private TypeOrder typeOrder;

    public AuthorizationComparator(TypeOrder typeOrder) {
        this.typeOrder = typeOrder;
    }

    @Override
    public int compare(Payment paymentOne, Payment paymentTwo) {
        if(paymentOne instanceof Card && paymentTwo instanceof Card) {
            Card cardOne = (Card)paymentOne;
            Card cardTwo = (Card)paymentTwo;
            return comparatorForCheck(cardOne, cardTwo);
        }

        if(paymentOne instanceof Transfer && paymentTwo instanceof Transfer) {
            Transfer transferOne = (Transfer)paymentOne;
            Transfer transferTwo = (Transfer)paymentTwo;
            return comparatorForTransfer(transferOne, transferTwo);
        }

        return 0;
    }

    private int comparatorForTransfer(Transfer transferOne, Transfer transferTwo) {
        if(this.typeOrder == TypeOrder.DESC) {
            return transferTwo.getAuthorization().compareTo(transferOne.getAuthorization());
        }
        return transferOne.getAuthorization().compareTo(transferTwo.getAuthorization());
    }

    private int comparatorForCheck(Card cardOne, Card cardTwo) {
        if(this.typeOrder == TypeOrder.DESC) {
            return cardTwo.getAuthorization().compareTo(cardOne.getAuthorization());
        }
        return cardOne.getAuthorization().compareTo(cardTwo.getAuthorization());
    }
}
