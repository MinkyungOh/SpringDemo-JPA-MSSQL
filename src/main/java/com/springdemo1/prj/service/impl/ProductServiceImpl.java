package com.springdemo1.prj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo1.prj.data.dto.ProductDTO;
import com.springdemo1.prj.data.repository.ProductRepository;
import com.springdemo1.prj.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public ProductDTO getProduct(String productId) {
		return repository.findById(productId).get().toDTO();
	}
	
	public ProductDTO saveProduct(ProductDTO productDTO) {
		return repository.save(productDTO.toEntity()).toDTO();
	}
	
	public ProductDTO deleteProduct(String productId) {
		return null;
	}
	
	public ProductDTO modifyProduct(ProductDTO productDTO) {
		return null;
	}
}
