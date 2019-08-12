package com.payments.domain.dtos;

import lombok.Getter;
import lombok.Setter;

/**
 * Class that contain data to sort a field.
 */
@Getter
@Setter
public class ColumnDto {
    private String columnName;
    private String order;
}
