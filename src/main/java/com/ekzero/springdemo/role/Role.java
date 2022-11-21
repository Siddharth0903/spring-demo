package com.ekzero.springdemo.role;

import lombok.*;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.ekzero.springdemo.user.User;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role implements Serializable{

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	@Id
	private int roleId;

	@Column(name = "role_name")
	private String roleName;
	
	@ManyToMany
	@JoinTable(name="user_roles",
			joinColumns = @JoinColumn(name="role_id", referencedColumnName = "role_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName="user_id"))
	private List<User> users;

	public Role(String roleName) {
		super();
		this.roleName = roleName;
		
	}
	
	

}
