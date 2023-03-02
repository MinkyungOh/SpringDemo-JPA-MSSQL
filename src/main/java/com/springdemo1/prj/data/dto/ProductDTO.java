package com.springdemo1.prj.data.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

	@NotNull
	@Size(min = 10, max = 10)
	private String productId;
	
	@NotNull
	private String productName;
	
	@NotNull
	@Min(value = 500)
	@Max(value = 3000000)
	private int productPrice;
	
	@NotNull
	@Min(value = 0)
	@Max(value = 99999)
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
