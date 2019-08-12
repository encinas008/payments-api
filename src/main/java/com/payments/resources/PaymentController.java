package com.payments.resources;

import com.payments.domain.CustomResponse;
import com.payments.domain.dtos.ColumnDto;
import com.payments.domain.dtos.PaymentDto;
import com.payments.domain.payment_way.Payment;
import com.payments.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Resources for payments.
 */
@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping(name = "Register a payment")
    public ResponseEntity<CustomResponse> createPayment(@Valid @RequestBody PaymentDto paymentDto) throws Exception {
        Payment payment = paymentService.createPayment(paymentDto);
        CustomResponse customResponse = new CustomResponse(HttpStatus.OK, "Successfully created a payment", null);
        customResponse.setData(payment);
        return new ResponseEntity(customResponse, customResponse.getStatusCode());
    }

    @GetMapping(name = "Get all payments")
    public ResponseEntity getAllPayments() throws Exception {
        List<Payment> listPayments = paymentService.getAllPayments();
        CustomResponse customResponse = new CustomResponse(HttpStatus.OK, "Successfully was get all payments", null);
        customResponse.setData(listPayments);
        return new ResponseEntity(customResponse, customResponse.getStatusCode());
    }

    @PostMapping(name = "Get all payments ordered by fields", value = "/sort")
    public ResponseEntity orderPayments(@RequestBody List<ColumnDto> fieldDtos)  throws Exception{
        List<Payment> listPayments = paymentService.orderPayments(fieldDtos);
        CustomResponse customResponse = new CustomResponse(HttpStatus.OK, "Successfully sorted the payments", null);
        customResponse.setData(listPayments);
        return new ResponseEntity(customResponse, customResponse.getStatusCode());
    }
}
