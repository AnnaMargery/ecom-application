package com.app.ecom.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orderItems")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "products_id", nullable = false)
	private Product product;
	private Integer quantity;
	private BigDecimal price;
	@ManyToOne
	@JoinColumn(name = "orders_id", nullable = false)
	private Order order;
}
