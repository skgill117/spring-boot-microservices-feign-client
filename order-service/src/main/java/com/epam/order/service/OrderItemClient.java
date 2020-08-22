package com.epam.order.service;

import java.util.List;

import com.epam.order.payload.OrderItemsDto;

public interface OrderItemClient {

	boolean saveorderItems(List<OrderItemsDto> orderItemsDto, Integer orderId);

	List<OrderItemsDto> getOrderItemsById(Integer orderId);

}
