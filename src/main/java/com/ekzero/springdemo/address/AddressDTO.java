package com.ekzero.springdemo.address;

import lombok.Data;

@Data
public class AddressDTO {
	private String streetNumber;
	private String streetName;
	private String city;
	private String country;
	private int pincode;

}
