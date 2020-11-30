package com.udacity.jwdnd.course1.cloudstorage.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;

@Controller
@RequestMapping("/home")
public class HomeController {
	private UserService userService;
	private NoteService noteService;
	
	public HomeController(final UserService userService, final NoteService noteService) {
		this.userService = userService;
		this.noteService = noteService;
	}
	
	@GetMapping
	public String getHomeMap(@ModelAttribute("note") NoteForm noteForm, Model model) {
		String currentUser = userService.findCurrentUsername(SecurityContextHolder.getContext().getAuthentication());
		User user = userService.findUser(currentUser);
		if(user == null || user.getUserId() == UserService.USER_NOT_FOUND) {
			return "home";
		}
		
		List<Note> notes = noteService.findAllNotes(user.getUserId());
		
		if(notes == null) {
			notes = new ArrayList<>();
		}
		
		model.addAttribute("notes", notes);
		
		return "home";
	}
	
	@PostMapping
	public String saveNote(@ModelAttribute("note") NoteForm noteForm, Model model) {
		String currentUsername = userService.findCurrentUsername(SecurityContextHolder.getContext().getAuthentication());
		Integer userId = noteService.findUserId(currentUsername);
		
		Note note = new Note(noteForm.getTitle(), noteForm.getDescription(), userId);
		noteService.createNote(note);
		noteService.setSuccessfullySaved(true);
		
		return "result";
	}
	
	@PutMapping
	public String updateNote(@ModelAttribute("note") NoteForm noteForm, Model model) {
		return "result";
	}
}
