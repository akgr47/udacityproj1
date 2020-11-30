package com.udacity.jwdnd.course1.cloudstorage.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;

@Service
public class NoteService {
	private NoteMapper noteMapper;
	private UserService userService;
	
	private boolean successfullySaved;
	
	public NoteService(final NoteMapper noteMapper, final UserService userService) {
		this.noteMapper = noteMapper;
		this.userService = userService;
	}
	
	public int createNote(final Note note) {
		return noteMapper.createNote(note);
	}
	
	public void update(final Note note) {
		noteMapper.updateNote(note);
	}
	
	public List<Note> findAllNotes(final Integer userId) {
		return noteMapper.findNotes(userId);
	}
	
	public Integer findUserId(final String username) {
		return userService.findUserId(username);
	}

	public boolean isSuccessfullySaved() {
		return successfullySaved;
	}

	public void setSuccessfullySaved(boolean successfullySaved) {
		this.successfullySaved = successfullySaved;
	}
}
