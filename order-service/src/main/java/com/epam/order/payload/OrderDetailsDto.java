package com.epam.order.payload;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class OrderDetailsDto {

	@NotNull
	@NotEmpty
	private String customerName;
	@NotNull
	private Date orderDate;
	@NotNull
	@NotEmpty
	private String shippingAddress;
	@NotNull
	private Double total;
	@NotNull
	@NotEmpty
	List<OrderItemsDto> orderItemsDto;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<OrderItemsDto> getOrderItemsDto() {
		return orderItemsDto;
	}

	public void setOrderItemsDto(List<OrderItemsDto> orderItemsDto) {
		this.orderItemsDto = orderItemsDto;
	}

}
