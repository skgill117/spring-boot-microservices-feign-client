package com.epam.order.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.order.payload.ApiResponse;
import com.epam.order.payload.OrderDetailsDto;
import com.epam.order.service.OrderDetailsService;

@RestController
@RequestMapping("/orders")
public class OrderServiceController {
	
	@Autowired
	private OrderDetailsService orderDetailsService;
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createOrder(@Valid @RequestBody OrderDetailsDto orderDetailsDto){
		Integer orderId = orderDetailsService.createOrder(orderDetailsDto);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "your order created successfully, order id is : " + orderId),HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/get/{orderId}")
	public OrderDetailsDto getOrder(@PathVariable(value = "orderId") Integer orderId){
		return orderDetailsService.getOrderById(orderId);
		
	}
	
	

}
