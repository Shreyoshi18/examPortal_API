package com.exam.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.config.JwtUtil;
import com.exam.entity.JwtRequest;
import com.exam.entity.JwtResponse;
import com.exam.entity.User;
import com.exam.helper.UserNotFoundException;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserDetailsService uerDetailsService;
	
	@RequestMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
	{
		try {
			authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
		}
		catch(UserNotFoundException e)
		{
			System.out.println("User not found "+e.getMessage());
		}
		
		UserDetails u = this.uerDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token  = jwtUtil.generateToken(u);
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	private void authenticate(String username, String password) throws Exception
	{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}
		catch(DisabledException e)
		{
			System.out.println("User is disabled " + e.getMessage());
			throw new Exception();
		}
		catch(BadCredentialsException e)
		{
			System.out.println("Invalid Credentials "+e.getMessage());
			throw new Exception();
		}
	}
	
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal)
	{
		return (User) this.uerDetailsService.loadUserByUsername(principal.getName());
	}
}
