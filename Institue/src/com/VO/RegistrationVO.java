package com.VO;

public class RegistrationVO {

private int userId;
private String firstName;
private String middleName;
private String lastName;
private int dob;
private String gurdainName;
private int gurdainContactNo;
private String address;
private String city;
private int zipCode;
private String state;
private String country;
private int contactNo;
private String lastExamName;
private String lastExamMarks;
private String boardName;
private String emailId;
private String password;
private String confirmPassword;

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getMiddleName() {
	return middleName;
}

public void setMiddleName(String middleName) {
	this.middleName = middleName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public int getDob() {
	return dob;
}

public void setDob(int dob) {
	this.dob = dob;
}

public String getGurdainName() {
	return gurdainName;
}

public void setGurdainName(String gurdainName) {
	this.gurdainName = gurdainName;
}

public int getGurdainContactNo() {
	return gurdainContactNo;
}

public void setGurdainContactNo(int gurdainContactNo) {
	this.gurdainContactNo = gurdainContactNo;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public int getZipCode() {
	return zipCode;
}

public void setZipCode(int zipCode) {
	this.zipCode = zipCode;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public int getContactNo() {
	return contactNo;
}

public void setContactNo(int contactNo) {
	this.contactNo = contactNo;
}

public String getLastExamName() {
	return lastExamName;
}

public void setLastExamName(String lastExamName) {
	this.lastExamName = lastExamName;
}

public String getLastExamMarks() {
	return lastExamMarks;
}

public void setLastExamMarks(String lastExamMarks) {
	this.lastExamMarks = lastExamMarks;
}

public String getBoardName() {
	return boardName;
}

public void setBoardName(String boardName) {
	this.boardName = boardName;
}

public String getEmailId() {
	return emailId;
}

public void setEmailId(String emailId) {
	this.emailId = emailId;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getConfirmPassword() {
	return confirmPassword;
}

public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}

public String toString() {
	return "RegistrationVO [userId=" + userId + ", firstName=" + firstName +",lastName = "+lastName+ ",dob="+dob+",gurdainName="+gurdainName+","
			+ ",gurdainContactNo="+gurdainContactNo+",address="+address+",city="+city+",zipCode="+zipCode+","
					+ ",state="+state+",country="+country+",contactNo="+contactNo+",last_exam_name="+lastExamName+","
							+ ",lastExamMarks="+lastExamMarks+",boardName="+boardName+",emailId=" + emailId + ","
									+ ",password="+password+",confirmPassword="+confirmPassword+" ]";
	
	
	
}
}