package com.payments.domain.payment_way;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * An class to create payment of type Transfer.
 */
@Getter
@Setter
public class Transfer extends Payment implements Serializable {
    private String nameBank;
    private String numberAccount;
    private String authorization;

    public Transfer() {
        super();
    }
}
