package com.epam.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderNotFoundException extends RuntimeException {
    private String customerName;

    public OrderNotFoundException( String customerName) {
        super(String.format("%s your order not found.", customerName));
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

   
}
