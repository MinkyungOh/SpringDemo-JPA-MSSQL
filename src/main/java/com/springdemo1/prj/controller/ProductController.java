package com.springdemo1.prj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo1.prj.data.dto.ProductDTO;
import com.springdemo1.prj.service.ProductService;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {
	
	private Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;
	
	// http://127.0.0.1:8080/api/v1/product-api/product/0
	@GetMapping(value = "/product/{productId}")
	public ProductDTO getProduct(@PathVariable String productId) {
		logger.info("ProductId: {}", productId);
		return productService.getProduct(productId);
	}
	
	// http://127.0.0.1:8080/api/v1/product-api/product
	@PostMapping(value = "/product")
	public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
		return productService.saveProduct(productDTO);
	}
	
	// http://127.0.0.1:8080/api/v1/product-api/product/0
	@DeleteMapping(value = "/product/{productId}")
	public ProductDTO deleteProduct(@PathVariable String productId) {
		return productService.deleteProduct(productId);
	}
	
	// http://127.0.0.1:8080/api/v1/product-api/product
	@PutMapping(value = "/product")
	public ProductDTO putProduct(@RequestBody ProductDTO productDTO) {
		return productService.modifyProduct(productDTO);
	}
}
