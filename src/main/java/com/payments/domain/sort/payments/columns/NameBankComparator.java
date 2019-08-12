package com.payments.domain.sort.payments.columns;

import com.payments.domain.payment_way.Payment;
import com.payments.domain.payment_way.Transfer;
import com.payments.domain.sort.TypeOrder;

import java.util.Comparator;

/**
 * An class comparator for name of Bank.
 */
public class NameBankComparator implements Comparator<Payment> {
    private TypeOrder typeOrder;

    public NameBankComparator(TypeOrder typeOrder) {
        this.typeOrder = typeOrder;
    }

    @Override
    public int compare(Payment paymentOne, Payment paymentTwo) {
        if(paymentOne instanceof Transfer && paymentTwo instanceof Transfer) {
            if(this.typeOrder == TypeOrder.DESC) {
                return ((Transfer)paymentTwo).getNameBank().compareTo(((Transfer)paymentOne).getNameBank());
            }
            return ((Transfer)paymentOne).getNameBank().compareTo(((Transfer)paymentTwo).getNameBank());
        }
        return 0;
    }

}
