package com.payments.domain.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Class for represent the input for make payments.
 */
@Getter
@Setter
public class PaymentDto {
    @NotNull(message = "Is not allowed blank date on service.")
    private LocalDate dateService;
    @NotNull(message = "Is not allowed blank of date of payment.")
    private LocalDate datePayment;

    @Min(value = 1, message = "Should be at least 1 the amount.")
    @Max(value = 999999999, message = "Max. value should be 999999999.")
    private double amount;

    @NotBlank(message = "Is not allowed blank concept.")
    private String concept;
    private String typePayment;

    private Integer checkNumber;

    @Min(value = 1000, message = "Should be at least 1000 digits of card.")
    @Max(value = 9999, message = "Max. value allowed is 9999.")
    private Integer lastDigits;
    private String authorization;

    private String nameBank;
    private String numberAccount;
}
