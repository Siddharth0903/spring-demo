package com.ekzero.springdemo.address;


import com.ekzero.springdemo.user.User;

import lombok.*;
import lombok.Setter;

import javax.persistence.*;

@ToString
@Getter
@NoArgsConstructor
@Setter
@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="address_id")
	private int addressId;
	
	@Column(name="street_number")
	private String streetNumber;
	
	@Column(name="street_name")
	private String streetName;
	
	@Column(name ="city")
	private String city;
	
	@Column(name = "country")
	private String country;
	
	@Column(name="pincode")
	private int pincode;
	
	@ManyToOne(cascade = {CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH,
			CascadeType.DETACH})
	@JoinColumn(name = "userId", referencedColumnName="user_id")
	private User user;
	

	public Address(String streetNumber, String streetName, String city, String country, int pincode) {
		super();
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.country = country;
		this.pincode = pincode;
		
	}
	

}
