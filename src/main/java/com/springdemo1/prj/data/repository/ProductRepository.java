package com.springdemo1.prj.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdemo1.prj.data.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

}
