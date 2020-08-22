package com.epam.order.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.epam.order.payload.OrderItemsDto;
import com.epam.order.service.OrderItemClient;

@Service
public class OrderItemClientImpl implements OrderItemClient {
	
	private static final Logger log = LoggerFactory.getLogger(OrderItemClientImpl.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	final String baseUrl = "http://localhost:8081/items";

	@Override
	public boolean saveorderItems(List<OrderItemsDto> orderItemsDto, Integer orderId) {
		try {
			HttpEntity<List<OrderItemsDto>> httpEntity = new HttpEntity<>(orderItemsDto, getHeader());
			String url = baseUrl + "/create" + "?orderId=" + orderId;
			ResponseEntity<Boolean> response = restTemplate.exchange(url, HttpMethod.POST,
					httpEntity, new ParameterizedTypeReference<Boolean>() {
					});
			return response.getBody();
		} catch (Exception e) {
			log.error("error while creating order items : " +e.getMessage());
		}
		return false;
	}
	
	private HttpHeaders getHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

	@Override
	public List<OrderItemsDto> getOrderItemsById(Integer orderId) {
		try {
			HttpEntity<?> httpEntity = new HttpEntity<>(getHeader());
			String url = baseUrl + "/get" + "/" + orderId;
			ResponseEntity<List<OrderItemsDto>> response = restTemplate.exchange(url, HttpMethod.GET,
					httpEntity, new ParameterizedTypeReference<List<OrderItemsDto>>() {
					});
			return response.getBody();
		} catch (Exception e) {
			log.error("error while getting order items : "+e.getMessage());
		}
		return new ArrayList<OrderItemsDto>();
	}

}
