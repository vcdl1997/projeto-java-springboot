package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Product;

// Camada reponsável por fazer operações com a entidade 
public interface ProductRepository extends JpaRepository<Product, Long>{
	
}