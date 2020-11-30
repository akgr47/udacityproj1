package com.udacity.jwdnd.course1.cloudstorage.services;

import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.User;

@Service
public class UserService {
	private UserMapper userMapper;
	private HashService hashService;
	
	public final static int USER_NOT_FOUND = -1;
	
	public UserService(final UserMapper userMapper, final HashService hashService) {
		this.userMapper = userMapper;
		this.hashService = hashService;
	}
	
	public int createUser(final User user) {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		
		String encodedSalt = Base64.getEncoder().encodeToString(salt);
		String hashedPassword = hashService.getHashedValue(user.getPassword(), encodedSalt);
		
		return userMapper.createUser(new User(null, user.getUsername().toLowerCase(), encodedSalt, hashedPassword, user.getFirstName(), user.getLastName()));
	}
	
	public boolean isUsernameAvailable(final String username) {
		User user = userMapper.findUser(username.toLowerCase());
		return user == null;
	}
	
	public User findUser(final String username) {
		return userMapper.findUser(username);
	}
	
	public Integer findUserId(final String username) {
		User user = findUser(username);
		return (user != null ? user.getUserId() : USER_NOT_FOUND);
	}
	
	public String findCurrentUsername(Authentication authentication) {
		return authentication.getName();
	}
}
