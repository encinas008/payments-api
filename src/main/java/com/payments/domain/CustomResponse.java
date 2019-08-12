package com.payments.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * An class to manage the responses.
 */
@Service
@Getter
@Setter
public class CustomResponse {
    private HttpStatus statusCode;
    private String message;
    private Object errors;
    private Object data;

    public CustomResponse() {}

    public CustomResponse(HttpStatus httpStatus, String localizedMessage, Object errors) {
        this.statusCode = httpStatus;
        this.message = localizedMessage;
        this.errors = errors;
    }
}

