package com.epam.order.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.order.entity.OrderItems;
import com.epam.order.payload.OrderItemsDto;
import com.epam.order.repository.OrderItemsRepo;
import com.epam.order.service.OrderItemsService;

@Service
public class OrderItemsServiceImpl implements OrderItemsService {
	
	@Autowired
	private OrderItemsRepo orderItemsRepo;

	@Override
	public Boolean createOrderItems(List<OrderItemsDto> orderItemsDto, Integer orderId) {
		List<OrderItems> list = new ArrayList<OrderItems>();
		if(null != orderItemsDto) {
			for(OrderItemsDto currObj : orderItemsDto) {
				OrderItems orderItems = new OrderItems();
				orderItems.setOrderId(orderId);
				orderItems.setProductCode(currObj.getProductCode());
				orderItems.setProductName(currObj.getProductName());
				orderItems.setQuantity(currObj.getQuantity());
				list.add(orderItems);
			}
			orderItemsRepo.saveAll(list);
		}
		return Boolean.TRUE;
	}

	@Override
	public List<OrderItemsDto> getOrderItems(Integer orderId) {
		List<OrderItemsDto> orderItems = new ArrayList<OrderItemsDto>();
		List<OrderItems> list = orderItemsRepo.findByOrderId(orderId);
		if(null != list) {
			for(OrderItems currObj : list) {
				OrderItemsDto orderItemsDto = new OrderItemsDto();
				orderItemsDto.setProductCode(currObj.getProductCode());
				orderItemsDto.setProductName(currObj.getProductName());
				orderItemsDto.setQuantity(currObj.getQuantity());
				orderItems.add(orderItemsDto);
			}
		}
		return orderItems;
	}
	

	
}
