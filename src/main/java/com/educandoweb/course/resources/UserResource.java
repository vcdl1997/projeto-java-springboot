package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

/*  A classe UserResource é uma das classes que irão compor a nossa camada de Controller
 * Sendo assim, a mesma recebe uma anotation "@RestController" e "@RequestMapping"
 * */

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		List<User> list = userService.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User user = userService.findById(id);
		
		return ResponseEntity.ok().body(user);
	}
	
	/* Retorna o código HTTP 201 (Created) - É padrão de resposta para requisições do tipo POST.
	 * Indica que a requisição foi bem sucedida e que um novo recurso foi criado.
	 * */
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		User user = userService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(uri).body(user);
	}
	
	// Retorna o código HTTP 204 (No Content) - É padrão de resposta para requisições do tipo delete
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		userService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
		User user = userService.update(id, obj);
		
		return ResponseEntity.ok().body(user);
	}
	
}