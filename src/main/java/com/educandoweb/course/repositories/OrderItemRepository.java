package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.OrderItem;
import com.educandoweb.course.entities.pk.OrderItemPK;

// Camada reponsável por fazer operações com a entidade 
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{
	
}