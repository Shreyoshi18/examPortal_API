package com.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.exam.entity.User;
import com.exam.services.UserService;

@SpringBootApplication
public class ExamApplication {

	
	public static void main(String[] args) {
		ApplicationContext con =  SpringApplication.run(ExamApplication.class, args);
		//UserService us = con.getBean(UserService.class);
		//us.deleteUser(2L);
	}

}
