package com.payments.domain.sort.payments.columns;

import com.payments.domain.payment_way.Payment;
import com.payments.domain.payment_way.Transfer;
import com.payments.domain.sort.TypeOrder;

import java.util.Comparator;

/**
 * An class comparator for number of account.
 */
public class AccountNumberComparator implements Comparator<Payment> {
    private TypeOrder typeOrder;

    public AccountNumberComparator(TypeOrder typeOrder) {
        this.typeOrder = typeOrder;
    }

    @Override
    public int compare(Payment paymentOne, Payment paymentTwo) {
        if(paymentOne instanceof Transfer && paymentTwo instanceof Transfer) {
            if(this.typeOrder == TypeOrder.DESC) {
                return ((Transfer)paymentTwo).getNumberAccount().compareTo(((Transfer)paymentOne).getNumberAccount());
            }
            return ((Transfer)paymentOne).getNumberAccount().compareTo(((Transfer)paymentTwo).getNumberAccount());
        }
        return 0;
    }
}
