package com.ekzero.springdemo.role;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekzero.springdemo.mapper.RoleMapper;
import com.ekzero.springdemo.mapper.mapperImpl.RoleMapperImpl;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private final RoleMapper roleMapper;
	
	public RoleDTO addRole(Role role) {
		roleRepository.save(role);
		 RoleDTO roleDTO = this.roleMapper.roleToDTO(role);
		 return roleDTO;
	}

	public List<RoleDTO> getRoles(){
		List<Role> roles = roleRepository.findAll();
		return this.roleMapper.roleListToDTO(roles);
	}
}
