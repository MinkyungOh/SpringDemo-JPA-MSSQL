package com.springdemo1.prj.data.dto;

import com.springdemo1.prj.data.entity.ProductEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

	private String productId;
	private String productName;
	private int productPrice;
	private int productStock;
	
	public ProductEntity toEntity() {
		return ProductEntity.builder()
				.productId(productId)
				.productName(productName)
				.productPrice(productPrice)
				.productStock(productStock)
				.build();
	}
}
