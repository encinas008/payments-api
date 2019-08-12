package com.payments.domain.sort.payments;

import com.payments.domain.payment_way.Payment;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by rafael.encinas on 8/9/2019.
 */
@Getter
@Setter
public class PaymentComparator implements Comparator<Payment> {
    private List<Comparator<Payment>> listComparators = new ArrayList<>();

    @Override
    public int compare(Payment paymentOne, Payment paymentTwo) {
        for (Comparator<Payment> comparator: listComparators) {
            int result = comparator.compare(paymentOne, paymentTwo);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}
