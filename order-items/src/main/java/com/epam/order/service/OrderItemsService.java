package com.epam.order.service;

import java.util.List;

import com.epam.order.payload.OrderItemsDto;

public interface OrderItemsService {

	Boolean createOrderItems(List<OrderItemsDto> orderItemsDto, Integer orderId);

	List<OrderItemsDto> getOrderItems(Integer orderId);



}
