package com.VO;

public class LoginVO {

private int userId;
private String userName;
private String password;


public String getUserName() {
	return userName;
}


public void setUserName(String userName) {
	this.userName = userName;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public String toString() {
	return "LoginVO [userId=" + userId + ", userName=" + userName + ", password="
			+ password + "]";
}
}
