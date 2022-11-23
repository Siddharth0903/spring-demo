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
		
		UserDTO userDTO = null;
		user.setRoles(verifyRoles(user));
		addressClassSetUser(user);
		
		
		userRepository.save(user);
		userDTO = this.userMapper.userToDTO(user);
		return userDTO;
	}
	

	
	public void addressClassSetUser(User user) {
		List<Address> addressList = user.getAddress();
		for(Address add : addressList) {
			add.setUser(user);
		}
	}
	
	public List<Role> verifyRoles(User user) throws ResourceNotFoundException{
		List<Role> roleList = roleRepository.findAll();
		List<Role> userRoleList = user.getRoles();
		List<Role> usersUpdatedRoleList = new ArrayList<Role>();
				
		for(Role roles : roleList){
			for(Role userRoles : userRoleList) {
				
				if(userRoles.getRoleId() == roles.getRoleId() &&
		            userRoles.getRoleName().equals(roles.getRoleName()))	{
					
					usersUpdatedRoleList.add(userRoles);
				}
					
				
			}
			
		}
		
		if(usersUpdatedRoleList == null) {
			throw new ResourceNotFoundException("Cannot find any roles");
		}

		return usersUpdatedRoleList;
		
		
	}
	
	public ResponseEntity<UserDTO> updateUser( int userId, User user) throws ResourceNotFoundException{
		User updateUser =  userRepository.findById(userId).get();
		
		updateUser.setUserId(userId);
		updateUser.setUserName(user.getUserName());
		updateUser.setUserEmail(user.getUserEmail());
		updateUser.setRoles(verifyRoles(user));
		updateUser.setAddress(user.getAddress());
		
		userRepository.save(updateUser);
		
		UserDTO userDTO = this.userMapper.userToDTO(updateUser);
		
		return ResponseEntity.ok(userDTO);
	}
	
	
	public  Map<String, Boolean> deleteUser(int userId) throws ResourceNotFoundException{
		User deleteUser = userRepository.findById(userId).get();
		userRepository.delete(deleteUser);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}


}
