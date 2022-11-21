package com.ekzero.springdemo.user;

import java.util.ArrayList; 
import java.util.HashMap;
import java.util.Optional;
import java.util.List;
import java.util.Map;

import javax.management.relation.Role;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ekzero.springdemo.exception.ResourceNotFoundException;


@Service
public class UserServiceImpl implements UserService {
	

	@Autowired
	private UserRepository userRepository;

	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	
	public ResponseEntity<User> getUser(int userId) throws ResourceNotFoundException {
		User user = userRepository.findById(userId).get();
		return ResponseEntity.ok(user);
	}
	
	
	public User addUser(User user) {
		userRepository.save(user);
		return user;
	}
	
	
	public ResponseEntity<User> updateUser( int userId, User user) throws ResourceNotFoundException{
		User updateUser =  userRepository.findById(userId).get();
				
		
		updateUser.setUserId(user.getUserId());
		updateUser.setUserName(user.getUserName());
		updateUser.setUserEmail(user.getUserEmail());
		updateUser.setAddress(user.getAddress());
		
		
		// here we need to check whether the roles match the given roles or not
		updateUser.setRoles(user.getRoles());
		
		
		return ResponseEntity.ok(updateUser);
	}
	
	
	public  Map<String, Boolean> deleteUser(int userId) throws ResourceNotFoundException{
		User deleteUser = userRepository.getById(userId);
		userRepository.delete(deleteUser);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}


}
