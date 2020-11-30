package com.udacity.jwdnd.course1.cloudstorage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udacity.jwdnd.course1.cloudstorage.model.SignupForm;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;

@Controller
@RequestMapping("/signup")
public class SignupController {
	private UserService userService;
	
	public SignupController(final UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public String getSignupPage(@ModelAttribute("newUser") SignupForm signupForm, Model model) {
		return "signup";
	}
	
	@PostMapping
	public String registerUser(@ModelAttribute("newUser") SignupForm signupForm, Model model) {
		if(userService.isUsernameAvailable(signupForm.getUsername().toLowerCase())) {
			User user = new User();
			user.setUsername(signupForm.getUsername().toLowerCase());
			user.setPassword(signupForm.getPassword());
			user.setFirstName(signupForm.getFirstName());
			user.setLastName(signupForm.getLastName());
			
			signupForm.setSuccesfullyRegistered(true);
			signupForm.setErrorMessageVisible(false);
			
			userService.createUser(user);
		}
		else {
			signupForm.setSuccesfullyRegistered(false);
			signupForm.setErrorMessageVisible(true);
		}
		
		signupForm.clearFields();
		
		return "signup";
	}
}
