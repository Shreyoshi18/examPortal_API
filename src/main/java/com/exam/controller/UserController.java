package com.exam.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.Roles;
import com.exam.entity.User;
import com.exam.entity.UserRoles;
import com.exam.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService us;
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	//Web service to create new User
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) throws Exception
	{
		user.setProfile("default.png");
		Roles role = new Roles();
		role.setrId(2L);
		role.setRoleName("Normal");
		
		UserRoles ur = new UserRoles();
		ur.setRole(role);
		ur.setUser(user);
		//ur.setUrId(1);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		System.out.println(user.getfName());
		Set<UserRoles> s = new HashSet();
		s.add(ur);
	
		//user.setUserRoles(s);
		return us.createUser(user,s);
		
	}
	
	//Web service to get User by Username
	@GetMapping("/{userName}")
	public User getUser(@PathVariable("userName") String userName)
	{
		return us.getUser(userName);
	}
	
	//Delete using userId
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId)
	{
		us.deleteUser(userId);
	}
}
