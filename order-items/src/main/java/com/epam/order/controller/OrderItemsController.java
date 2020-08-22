package com.epam.order.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epam.order.payload.OrderItemsDto;
import com.epam.order.service.OrderItemsService;

@RestController
@RequestMapping("/items")
public class OrderItemsController {
	
	private static final Logger log = LoggerFactory.getLogger(OrderItemsController.class);

	@Autowired
	private OrderItemsService orderItemssService;

	@PostMapping("/create")
	public ResponseEntity<Boolean> createOrderItems(@RequestBody List<OrderItemsDto> orderItemsDto,
			@RequestParam Integer orderId) {
		log.info("ordered items are : - " + orderItemsDto);
		return new ResponseEntity<Boolean>(orderItemssService.createOrderItems(orderItemsDto, orderId),
				HttpStatus.ACCEPTED);

	}

	@GetMapping("/get/{orderId}")
	public List<OrderItemsDto> getOrderItems(@PathVariable(value = "orderId") Integer orderId) {

		return orderItemssService.getOrderItems(orderId);
	}

}
