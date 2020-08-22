package com.epam.order.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.epam.order.entity.OrderItems;

public interface OrderItemsRepo extends CrudRepository<OrderItems, Integer> {

	List<OrderItems> findByOrderId(Integer orderId);


}
