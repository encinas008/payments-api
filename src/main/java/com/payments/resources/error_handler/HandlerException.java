package com.payments.resources.error_handler;

import com.payments.domain.CustomResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Component
public class HandlerException extends ResponseEntityExceptionHandler {
    @Value("Some Fields are required.")
    private String messageFailedValidation;

    @Value("Contact with the Admin.")
    private String messageContactToAdmin;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        String message = "";
        for (ObjectError error: ex.getBindingResult().getAllErrors()) {
            String errorMessage = error.getDefaultMessage();
            message += errorMessage + "\n";
        }

        CustomResponse customResponse = new CustomResponse(HttpStatus.BAD_REQUEST, message, null);

        return new ResponseEntity<>(customResponse, customResponse.getStatusCode());
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
            String error = ex.getParameterName() + " parameter is missing";

        CustomResponse customResponse = new CustomResponse(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
        return new ResponseEntity<>(customResponse, customResponse.getStatusCode());
    }
}