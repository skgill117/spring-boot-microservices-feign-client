package com.epam.order.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.epam.order.payload.OrderItemsDto;

@FeignClient(name="order-items" )
public interface OrderItemFeignClient {
	
	@PostMapping("/items/create")
	public ResponseEntity<Boolean> createOrderItems(@RequestBody List<OrderItemsDto> orderItemsDto,
			@RequestParam Integer orderId); 
	@GetMapping("/items/get/{orderId}")
	public List<OrderItemsDto> getOrderItems(@PathVariable(value = "orderId") Integer orderId); 

}
