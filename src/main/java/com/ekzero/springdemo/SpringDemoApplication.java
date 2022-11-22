package com.ekzero.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ekzero.springdemo.mapper.RoleMapper;
import com.ekzero.springdemo.mapper.UserMapper;

@SpringBootApplication
@EnableJpaAuditing

public class SpringDemoApplication {
	
	public static void main(String[] args) {

		SpringApplication.run(SpringDemoApplication.class, args);
	}

}
