/**
 * 
 */
package com.ekzero.springdemo.user;

import java.util.List;

import com.ekzero.springdemo.role.Role;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


}
