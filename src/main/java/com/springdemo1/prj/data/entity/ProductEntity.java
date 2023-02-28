package com.springdemo1.prj.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.springdemo1.prj.data.dto.ProductDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "test_product")
public class ProductEntity {

	@Id
	private String productId;
	private String productName;
	private int productPrice;
	private int productStock;
	
	public ProductDTO toDTO() {
		return ProductDTO.builder()
				.productId(productId)
				.productName(productName)
				.productPrice(productPrice)
				.productStock(productStock)
				.build();
	}
}
