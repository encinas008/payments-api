package com.payments.domain.sort.payments;

import com.payments.domain.dtos.ColumnDto;
import com.payments.domain.payment_way.Payment;
import com.payments.domain.sort.TypeOrder;
import com.payments.domain.sort.payments.columns.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Class to build a Payment Comparator.
 */
@Getter
public class PaymentComparatorFactory {
    PaymentComparator paymentComparator;

    public PaymentComparatorFactory(List<ColumnDto> columnDtos) {
        paymentComparator = new PaymentComparator();
        List<Comparator<Payment>> comparators = buildListComparators(columnDtos);
        paymentComparator.setListComparators(comparators);
    }

    private List<Comparator<Payment>> buildListComparators(List<ColumnDto> columnDtos) {
        List<Comparator<Payment>> listComparators = new ArrayList<>();
        Comparator<Payment> comparator = null;
        for (ColumnDto fieldToSort: columnDtos) {
            TypeOrder typeOrder = getTypeOrder(fieldToSort.getOrder());
            switch (fieldToSort.getColumnName()) {
                case "typePayment":
                    comparator = new TypePaymentComparator(typeOrder);
                    break;
                case "dateService":
                    comparator = new DateServiceComparator(typeOrder);
                    break;
                case "datePayment":
                    comparator = new DatePaymentComparator(typeOrder);
                    break;
                case "concept":
                    comparator = new ConceptComparator(typeOrder);
                    break;
                case "checkNumber":
                    comparator = new CheckNumberComparator(typeOrder);
                    break;
                case "lastDigits":
                    comparator = new LastDigitsComparator(typeOrder);
                    break;
                case "nameBank":
                    comparator = new NameBankComparator(typeOrder);
                    break;
                case "numberAccount":
                    comparator = new AccountNumberComparator(typeOrder);
                    break;
                case "authorization":
                    comparator = new AuthorizationComparator(typeOrder);
                    break;
                case "amount":
                    comparator = new AmountComparator(typeOrder);
                    break;
            }
            listComparators.add(comparator);
        }
        return listComparators;
    }

    private TypeOrder getTypeOrder(String order) {
        return order.equals("DESC") ? TypeOrder.DESC : TypeOrder.ASC;
    }
}
