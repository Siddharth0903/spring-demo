package com.ekzero.springdemo.mapper.mapperImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import com.ekzero.springdemo.address.Address;
import com.ekzero.springdemo.address.AddressDTO;
import com.ekzero.springdemo.mapper.UserMapper;
import com.ekzero.springdemo.role.Role;
import com.ekzero.springdemo.role.RoleDTO;
import com.ekzero.springdemo.user.User;
import com.ekzero.springdemo.user.UserDTO;

@Generated(value = "org.mapstruct.ap.MappingProcessor" )
@Component
public class UserMapperImpl implements UserMapper {
	
	public UserDTO userToDTO(User user) {
		
		if(user == null) return null;
		
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserId(user.getUserId());
		userDTO.setUserName(user.getUserName());
		userDTO.setUserEmail(user.getUserEmail());
		userDTO.setRoles(roleListToDTO(user.getRoles()));
		userDTO.setAddress(addressListToDTO(user.getAddress()));
		
		return userDTO;
	}
	
	public List<UserDTO> userListToDTO(List<User> userList){
		if(userList == null) return null;
		
		List<UserDTO> userDTOList = new ArrayList<UserDTO>(userList.size());
		
		for(User user : userList) {
			userDTOList.add(userToDTO(user));
		}
		
		return userDTOList;
	}
	
	public RoleDTO roleToDTO (Role role) {
		if (role == null) return null;
		
		RoleDTO roleDTO = new RoleDTO();
		
		roleDTO.setRoleId(role.getRoleId());
		roleDTO.setRoleName(role.getRoleName());
		
		return roleDTO;
	}
	
	public List<RoleDTO>  roleListToDTO(List<Role> roleList){
		if(roleList == null) return null;
		
		List<RoleDTO> roleDTOList = new ArrayList<RoleDTO>(roleList.size());
		for (Role role : roleList) {
			roleDTOList.add(roleToDTO(role));
		}
		
		return roleDTOList;
	}
	
	
	public AddressDTO addressToDTO(Address address) {
		if(address == null ) return null;
		
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setStreetNumber(address.getStreetNumber());
		addressDTO.setStreetName(address.getStreetName());
		addressDTO.setCity(address.getCity());
		addressDTO.setCountry(address.getCountry());
		addressDTO.setPincode(address.getPincode());
		return addressDTO;
	}
	
	public List<AddressDTO> addressListToDTO(List<Address> addressList){
		if(addressList == null) return null;
		
		List<AddressDTO> addDTOList = new ArrayList(addressList.size());
		
		for(Address add : addressList) {
			addDTOList.add(addressToDTO(add));
		}
		
		return addDTOList;
	}


}
