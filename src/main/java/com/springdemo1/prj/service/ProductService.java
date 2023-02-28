package com.springdemo1.prj.service;

import com.springdemo1.prj.data.dto.ProductDTO;

public interface ProductService {

	public ProductDTO getProduct(String productId);
	
	public ProductDTO saveProduct(ProductDTO productDTO);
	
	public ProductDTO deleteProduct(String productId);
	
	public ProductDTO modifyProduct(ProductDTO productDTO);
	
}
