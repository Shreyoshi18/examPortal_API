package com.exam.servicesImpl;

import java.util.Set;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entity.User;
import com.exam.entity.Roles;
import com.exam.entity.UserRoles;
import com.exam.helper.UserFoundException;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import com.exam.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleRepository roleRepo;
	@Override
	public User createUser(User user, Set<UserRoles> userRole) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("\nChecking if username exists");
		User local = userRepo.findByUserName(user.getUserName());
		if(local != null)
		{
			System.out.println("Username already exists");
			throw new UserFoundException();
		}
		else
		{
			System.out.println("\nCreating new User");
			for(UserRoles ur: userRole)
			{
				Roles r = ur.getRole();
				r = roleRepo.save(r);
				System.out.println("Inserting : "+r.getrId()+" "+r.getRoleName());
			}
			user.setUserRoles(userRole);
			local = userRepo.save(user);
		}
		return local;
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		
		return userRepo.findByUserName(username);
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRepo.deleteById(id);
	}

}
