package com.app.ecom.mapper;

import com.app.ecom.dto.OrderItemDto;
import com.app.ecom.dto.OrderResponse;
import com.app.ecom.model.Order;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

	public OrderResponse mapToOrderResponse(Order order) {
		return new OrderResponse(order.getId(), order.getAmount(), order.getStatus(), order.getItems().stream()
				.map(item -> new OrderItemDto(item.getId(), item.getProduct().getId(), item.getQuantity(),
						item.getPrice(), item.getPrice().multiply(new BigDecimal(item.getQuantity()))))
				.toList(), order.getCreatedAt());
	}

}
