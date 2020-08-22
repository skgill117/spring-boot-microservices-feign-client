package com.epam.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderNotFoundException extends RuntimeException {
    private Integer orderId;

    public OrderNotFoundException(Integer orderId) {
        super(String.format("Order with id %s not found.", orderId));
        this.orderId = orderId;
    }

    public Integer getOrderId() {
        return orderId;
    }

   
}
