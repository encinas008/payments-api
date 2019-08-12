package com.payments.domain.payment_way;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * An class to create payments of type Card.
 */
@Getter
@Setter
public class Card extends Payment implements Serializable {
    private Integer lastDigits;
    private String authorization;

    public Card() {
        super();
    }
}
