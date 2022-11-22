package com.ekzero.springdemo.mapper;

import com.ekzero.springdemo.address.Address;
import com.ekzero.springdemo.address.AddressDTO;
import org.mapstruct.*;

@Mapper
public interface AddressMapper {
	
	AddressDTO addressToDTO(Address address);

}
