package com.exam.services;

import java.util.Set;

import com.exam.entity.User;
import com.exam.entity.UserRoles;

public interface UserService {

	public User createUser(User user, Set<UserRoles> userRole) throws Exception;
	public User getUser(String username);
	public void deleteUser(Long id);
}
