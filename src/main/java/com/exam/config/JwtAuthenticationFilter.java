package com.exam.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.exam.servicesImpl.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsserviceimpl;
	@Autowired
	private JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String requestTokenHeader = request.getHeader("Authorization");
		System.out.println(requestTokenHeader);
		String username = null;
		String jwtToken = null;
		if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken  = requestTokenHeader.substring(7);
			try {
			username = jwtUtil.extractUsername(jwtToken);
			System.out.println(username);
			}
			catch(ExpiredJwtException e)
			{
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Invalid Token");
			
		}
		
		//validate
		
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UserDetails userDetails = this.userDetailsserviceimpl.loadUserByUsername(username);
			if(jwtUtil.validateToken(jwtToken, userDetails))
			{
				UsernamePasswordAuthenticationToken u =new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				u.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(u);
			}
		}
		else
		{
			System.out.println("Invalid Token!!!");
		}
		
		filterChain.doFilter(request, response);
		}

}
