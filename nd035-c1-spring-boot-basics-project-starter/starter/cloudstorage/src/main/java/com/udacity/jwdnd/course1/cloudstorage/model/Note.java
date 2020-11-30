package com.udacity.jwdnd.course1.cloudstorage.model;

public class Note {
	private Integer noteId;
	private String title;
	private String description;
	private Integer userId;
	
	public Note(final Integer noteId, 
			    final String title, 
			    final String description, 
			    final Integer userId) {
		this.noteId = noteId;
		this.title = title;
		this.description = description;
		this.userId = userId;
	}
	
	public Note(final String title, final String description, final Integer userId) {
		this(0, title, description, userId);
	}
	
	public Note() {
		this(0, "", "", 0);
	}

	public Integer getNoteId() {
		return noteId;
	}

	public void setNoteId(Integer notesId) {
		this.noteId = notesId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(final Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", title=" + title + ", description=" + description + ", userId=" + userId
				+ "]";
	}
}
