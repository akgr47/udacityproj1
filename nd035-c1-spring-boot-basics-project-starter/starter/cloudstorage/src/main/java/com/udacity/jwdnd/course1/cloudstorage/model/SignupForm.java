package com.udacity.jwdnd.course1.cloudstorage.model;

public class SignupForm {
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private boolean succesfullyRegistered;
	private boolean errorMessageVisible;
	private boolean usernameAvailable;
	
	public void clearFields() {
		firstName = "";
		lastName = "";
		username = "";
		password = "";
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isSuccesfullyRegistered() {
		return succesfullyRegistered;
	}
	public void setSuccesfullyRegistered(boolean succesfullyRegistered) {
		this.succesfullyRegistered = succesfullyRegistered;
	}
	
	public boolean isErrorMessageVisible() {
		return errorMessageVisible;
	}
	public void setErrorMessageVisible(boolean errorMessageVisible) {
		this.errorMessageVisible = errorMessageVisible;
	}
	
	public boolean isUsernameAvailable() {
		return usernameAvailable;
	}
	public void setUsernameAvailable(boolean usernameAvailable) {
		this.usernameAvailable = usernameAvailable;
	}
}
