package com.ekzero.springdemo.organization;
import com.ekzero.springdemo.user.User; 

import lombok.*;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


//They neeed a primary key in every Entity
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="organization")
public class Organization implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "org_id")
	private int orgId;
	
	public Organization(String orgName, String location) {
		super();
		this.orgName = orgName;
		this.location = location;
	
	}

	@Column(name="org_name")
	private String orgName;
	
	@Column(name="location")
	private String location;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<User> users;

}
