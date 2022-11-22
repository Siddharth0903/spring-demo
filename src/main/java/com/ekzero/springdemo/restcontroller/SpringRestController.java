package com.ekzero.springdemo.restcontroller;

import java.util.HashMap;  
import java.util.List;
import java.util.Map;
import org.mapstruct.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;

import com.ekzero.springdemo.exception.ResourceNotFoundException;
import com.ekzero.springdemo.mapper.RoleMapper;
import com.ekzero.springdemo.role.Role;
import com.ekzero.springdemo.role.RoleDTO;
import com.ekzero.springdemo.role.RoleRepository;
import com.ekzero.springdemo.role.RoleServiceImpl;
import com.ekzero.springdemo.user.*;


@RestController
@RequestMapping("/api")
public class SpringRestController {
	
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private RoleServiceImpl roleServiceImpl;
	
	@GetMapping("/users")
	public List<UserDTO> getUsers(){
		return userServiceImpl.getUsers();
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<UserDTO> getUser(@PathVariable int userId) throws ResourceNotFoundException {
		return userServiceImpl.getUser(userId);
	}
	
	@PostMapping("/users")
	public UserDTO addUser(@Valid @RequestBody User user) throws ResourceNotFoundException {
		return userServiceImpl.addUser(user);
		
	}
	
	@PutMapping("/users/{userId}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable(value ="userId") int userId,
			@Valid @RequestBody User user) throws ResourceNotFoundException{
		return userServiceImpl.updateUser(userId, user);
	}
	
	@DeleteMapping("/users/{userId}")
	public  Map<String, Boolean> deleteUser(@PathVariable int userId) throws ResourceNotFoundException{
		return userServiceImpl.deleteUser(userId);
	}
	
	@PostMapping("/add")
	public RoleDTO addRole(@Valid @RequestBody Role role){
		 return roleServiceImpl.addRole(role);
	}
	
	@GetMapping("/fetch")
	public List<RoleDTO> getRoles(){
		return roleServiceImpl.getRoles();
	}

}
