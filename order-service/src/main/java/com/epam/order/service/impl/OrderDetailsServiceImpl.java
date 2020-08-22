package com.epam.order.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.order.entity.OrderDetails;
import com.epam.order.exception.AppException;
import com.epam.order.exception.OrderNotFoundException;
import com.epam.order.payload.OrderDetailsDto;
import com.epam.order.payload.OrderItemsDto;
import com.epam.order.repository.OrderDetailsRepo;
import com.epam.order.service.OrderDetailsService;
import com.epam.order.service.OrderItemClient;
import com.epam.order.service.OrderItemFeignClient;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
	
	@Autowired
	private OrderDetailsRepo orderDetailsRepo;
	
	@Autowired
	private OrderItemClient orderItemClient;
	
	@Autowired
	private OrderItemFeignClient orderItemFeignClient;

	@Override
	public Integer createOrder(OrderDetailsDto orderDetailsDto) {
		OrderDetails savedObj = orderDetailsRepo.save(getOrderEntity(orderDetailsDto));
		//boolean savedItems = orderItemClient.saveorderItems(orderDetailsDto.getOrderItemsDto(),savedObj.getOrderId());
		boolean savedItems = orderItemFeignClient.createOrderItems(orderDetailsDto.getOrderItemsDto(),savedObj.getOrderId()).getBody();
		if(!savedItems) {
			throw new AppException("Order items service is down.");
		}
		return savedObj.getOrderId();
	}

	private OrderDetails getOrderEntity(OrderDetailsDto orderDetailsDto) {
		OrderDetails od = new OrderDetails();
		od.setCustomerName(orderDetailsDto.getCustomerName());
		od.setOrderDate(orderDetailsDto.getOrderDate());
		od.setShippingAddress(orderDetailsDto.getShippingAddress());
		od.setTotal(orderDetailsDto.getTotal());
		return od;
	}

	@Override
	public OrderDetailsDto getOrderById(Integer orderId) {
		OrderDetailsDto orderDetailsDto = null;
		Optional<OrderDetails> od = orderDetailsRepo.findById(orderId);
		if(od.isPresent()) {
			OrderDetails orderdetails = od.get();
			orderDetailsDto = getOrderDto(orderdetails);
		}else {
			throw new OrderNotFoundException(orderId);
		}
		//List<OrderItemsDto> orderItemsDto = orderItemClient.getOrderItemsById(orderId);
		List<OrderItemsDto> orderItemsDto =  orderItemFeignClient.getOrderItems(orderId);
		if(null == orderItemsDto || orderItemsDto.size() == 0) {
			throw new OrderNotFoundException(orderId);
		}
		orderDetailsDto.setOrderItemsDto(orderItemsDto);
		return orderDetailsDto;
	}

	private OrderDetailsDto getOrderDto(OrderDetails orderdetails) {
		OrderDetailsDto orderDetailsDto = new OrderDetailsDto();
		orderDetailsDto.setCustomerName(orderdetails.getCustomerName());
		orderDetailsDto.setOrderDate(orderdetails.getOrderDate());
		orderDetailsDto.setShippingAddress(orderdetails.getShippingAddress());
		orderDetailsDto.setTotal(orderdetails.getTotal());
		return orderDetailsDto;
	}
	

	
}
