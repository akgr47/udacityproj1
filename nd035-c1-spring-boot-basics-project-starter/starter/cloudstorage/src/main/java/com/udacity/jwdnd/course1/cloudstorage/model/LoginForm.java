package com.udacity.jwdnd.course1.cloudstorage.model;

public class LoginForm {
	private String username;
	private String password;
	private boolean validCredentials;
	private boolean logoutMessageVisible;
	private boolean invalidCredentialsMessageVisible;
	
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
	public boolean isValidCredentials() {
		return validCredentials;
	}
	public void setValidCredentials(boolean validCredentials) {
		this.validCredentials = validCredentials;
	}
	public boolean isLogoutMessageVisible() {
		return logoutMessageVisible;
	}
	public void setLogoutMessageVisible(boolean logoutMessageVisible) {
		this.logoutMessageVisible = logoutMessageVisible;
	}
	public boolean isInvalidCredentialsMessageVisible() {
		return invalidCredentialsMessageVisible;
	}
	public void setInvalidCredentialsMessageVisible(boolean invalidCredentialsMessageVisible) {
		this.invalidCredentialsMessageVisible = invalidCredentialsMessageVisible;
	}
	
	
}
