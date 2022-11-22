package com.ekzero.springdemo.mapper.mapperImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import com.ekzero.springdemo.mapper.RoleMapper;
import com.ekzero.springdemo.role.Role;
import com.ekzero.springdemo.role.RoleDTO;

@Generated(value = "org.mapstruct.ap.MappingProcessor" )
@Component
public class RoleMapperImpl implements RoleMapper {

	@Override
	public RoleDTO roleToDTO(Role role) {
		if (role == null) return null;
		
		RoleDTO roleDTO = new RoleDTO();
		
		roleDTO.setRoleId(role.getRoleId());
		roleDTO.setRoleName(role.getRoleName());
		
		return roleDTO;
	}

	@Override
	public List<RoleDTO> roleListToDTO(List<Role> roleList) {
		if(roleList == null) return null;
		
		List<RoleDTO> roleDTOList = new ArrayList<RoleDTO>(roleList.size());
		for (Role role : roleList) {
			roleDTOList.add(roleToDTO(role));
		}
		
		return roleDTOList;
	}

}
