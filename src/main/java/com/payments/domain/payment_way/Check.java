package com.payments.domain.payment_way;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * An class to create payments of type Check.
 */
@Getter
@Setter
public class Check extends Payment implements Serializable {
    private Integer checkNumber;

    public Check() {
        super();
    }
}
