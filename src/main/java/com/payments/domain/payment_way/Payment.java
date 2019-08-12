package com.payments.domain.payment_way;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * An class base to create different kind of payments.
 */
@Getter
@Setter
public abstract class Payment implements Serializable {
    private LocalDate dateService;
    private LocalDate datePayment;
    private Double amount;
    private String concept;
    private String typePayment;
}
