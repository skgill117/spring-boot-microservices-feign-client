package com.epam.order.service;

import com.epam.order.payload.OrderDetailsDto;

public interface OrderDetailsService {

	Integer createOrder(OrderDetailsDto orderDetailsDto);

	OrderDetailsDto getOrderById(Integer orderId);



}
