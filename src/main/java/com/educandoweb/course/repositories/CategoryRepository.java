package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Category;

// Camada reponsável por fazer operações com a entidade 
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}