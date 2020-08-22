package com.epam.order.repository;

import org.springframework.data.repository.CrudRepository;

import com.epam.order.entity.OrderDetails;

public interface OrderDetailsRepo extends CrudRepository<OrderDetails, Integer> {


}
