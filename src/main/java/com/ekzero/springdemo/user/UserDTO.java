package com.ekzero.springdemo.user;

import java.util.List;
import lombok.Data;

import com.ekzero.springdemo.address.Address;
import com.ekzero.springdemo.address.AddressDTO;
import com.ekzero.springdemo.organization.OrganizationDTO;
import com.ekzero.springdemo.role.Role;
import com.ekzero.springdemo.role.RoleDTO;

@Data
public class UserDTO {
	
	private int userId;
	
	private String userName;
	
	private String userEmail;
	
	private List<RoleDTO> roles;
	
	private List<AddressDTO> address;
	
	private OrganizationDTO organization;

}
