package com.ekzero.springdemo.mapper;

import java.util.List; 
import org.mapstruct.*;


import com.ekzero.springdemo.role.Role;
import com.ekzero.springdemo.role.RoleDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {
	
	RoleDTO roleToDTO(Role role);
	
	List<RoleDTO> roleListToDTO(List<Role> role); 

}
