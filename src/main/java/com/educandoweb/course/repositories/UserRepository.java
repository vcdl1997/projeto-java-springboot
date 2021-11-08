package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.User;

// Camada reponsável por fazer operações com a entidade 
public interface UserRepository extends JpaRepository<User, Long>{
	
}