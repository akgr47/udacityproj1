package com.udacity.jwdnd.course1.cloudstorage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udacity.jwdnd.course1.cloudstorage.model.LoginForm;
import com.udacity.jwdnd.course1.cloudstorage.services.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping
	public String getLoginPage(@ModelAttribute("user") LoginForm loginForm, Model model) {
		return "login";
	}
	
	@PostMapping
	public String logIn(@ModelAttribute("user") LoginForm loginForm, Model model) {
		return "login";
	}
}
