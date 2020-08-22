package com.epam.order.payload;

public class OrderItemsDto {

	private String productCode;
	private String productName;
	private Integer quantity;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItemsDto [productCode=" + productCode + ", ProductName=" + productName + ", quantity=" + quantity
				+ "]";
	}
	
	

}
