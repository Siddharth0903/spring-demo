package com.ekzero.springdemo.user;

import java.util.ArrayList;   
 
import java.util.HashMap;
import java.util.Optional;
import java.util.List;
import java.util.Map;
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

import com.ekzero.springdemo.address.Address;
import com.ekzero.springdemo.exception.ResourceNotFoundException;
import com.ekzero.springdemo.mapper.RoleMapper;
import com.ekzero.springdemo.mapper.UserMapper;
import com.ekzero.springdemo.mapper.mapperImpl.UserMapperImpl;
import com.ekzero.springdemo.role.RoleRepository;
import com.ekzero.springdemo.role.*;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private final UserMapper userMapper;

	
	public List<UserDTO> getUsers(){
		List<User> users = userRepository.findAll();
	     List<UserDTO> usersDTO = userMapper.userListToDTO(users);
	     return usersDTO;
		
	}
	
	
	public ResponseEntity<UserDTO> getUser(int userId) throws ResourceNotFoundException {
		User user = userRepository.findById(userId).get();
		UserDTO userDTO = this.userMapper.userToDTO(user);
		return ResponseEntity.ok(userDTO);
	}
	
	
	public UserDTO addUser(User user) throws ResourceNotFoundException {
		List<Role> roleList = roleRepository.findAll();
		List<Role> userRoleList = user.getRoles();
		List<Address> addressList;
		UserDTO userDTO = null;
		
		for(Role roles : roleList){
			for(Role userRoles : userRoleList) {
				
				if(userRoles.getRoleId() == roles.getRoleId() &&
		            userRoles.getRoleName() == roles.getRoleName())	{
					
					userRoleList.add(userRoles);
				}
					
				
			}
			
		}

		user.setRoles(userRoleList);
		userRepository.save(user);
		userDTO = this.userMapper.userToDTO(user);
		return userDTO;
	}
	
	
	public ResponseEntity<UserDTO> updateUser( int userId, User user) throws ResourceNotFoundException{
		User updateUser =  userRepository.findById(userId).get();
				
		
		updateUser.setUserId(user.getUserId());
		updateUser.setUserName(user.getUserName());
		updateUser.setUserEmail(user.getUserEmail());
		updateUser.setAddress(user.getAddress());
		
		
		// here we need to check whether the roles match the given roles or not
		updateUser.setRoles(user.getRoles());
		
		UserDTO userDTO = this.userMapper.userToDTO(updateUser);
		
		return ResponseEntity.ok(userDTO);
	}
	
	
	public  Map<String, Boolean> deleteUser(int userId) throws ResourceNotFoundException{
		User deleteUser = userRepository.getById(userId);
		userRepository.delete(deleteUser);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}


}
