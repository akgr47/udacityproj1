package com.udacity.jwdnd.course1.cloudstorage.services;

import org.springframework.stereotype.Service;
import com.udacity.jwdnd.course1.cloudstorage.model.User;

@Service
public class LoginService {
	private UserService userService;
	
	public LoginService(final UserService userService) {
		this.userService = userService;
	}
	
	public boolean isUsernamePasswordValid(final String username, final String password) {
		User user = userService.findUser(username);
		if(user == null)
			return false;
		else {
			if(user.getPassword().equals(password)) {
				return true;
			}
		}
		
		return false;
	}
}
