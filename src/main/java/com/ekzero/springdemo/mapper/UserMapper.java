package com.ekzero.springdemo.mapper;

import com.ekzero.springdemo.user.User; 
import com.ekzero.springdemo.user.UserDTO;

import java.util.List;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
	
	UserDTO userToDTO(User user);
	List<UserDTO> userListToDTO(List<User> user);

}
