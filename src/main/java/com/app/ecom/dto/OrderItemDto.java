package com.app.ecom.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItemDto {

	private Long id;
	private Long productId;
	private Integer quantity;
	private BigDecimal price;
	private BigDecimal subTotal;
}
