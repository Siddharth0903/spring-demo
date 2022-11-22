package com.ekzero.springdemo.user;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.ekzero.springdemo.address.Address;
import com.ekzero.springdemo.organization.Organization;
import com.ekzero.springdemo.role.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;
import lombok.Setter;

import java.util.List;

import javax.persistence.*;

@Getter
@JsonIgnoreProperties
@NoArgsConstructor
@Setter
@Entity
@Table(name="users")
public class User {
			
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "user_id")
	@Id
	private int userId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "user_email")
	private String userEmail;
	
	@ManyToMany
	@JoinTable(name="user_roles",
			joinColumns = @JoinColumn(name="user_id", referencedColumnName = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName="role_id"))
	private List<Role> roles;
	
	@OneToMany(mappedBy = "user", cascade = {CascadeType.MERGE,
											CascadeType.PERSIST,
											CascadeType.REFRESH,
											CascadeType.DETACH})
	private List<Address> address;
	
//	@ManyToOne
//	private Organization organization;

	public User(String userName, String userEmail, List<Role> roles, List<Address> address) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.roles = roles;
		this.address = address;
		
	}
	
	
	
	
	
	
	
}
