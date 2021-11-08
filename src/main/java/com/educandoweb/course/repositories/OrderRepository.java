package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Order;

// Camada reponsável por fazer operações com a entidade 
public interface OrderRepository extends JpaRepository<Order, Long>{
	
}