package com.bean;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.VO.RegistrationVO;
import com.VO.StudentVO;
import com.dao.RegistrationDAO;

public class StudentBean {
	
	private StudentVO studentVO;
	private List<RegistrationVO> currentStudList = new ArrayList<RegistrationVO>();
	private String headerStr = null; 
	private String statusChangeBtnVal = null; 
	
	public StudentBean() {
		studentVO = new StudentVO();
		retrieveStudentList("active");
		System.out.println("Inside the student bean");
	}

	public StudentVO getStudentVO() {
		return studentVO;
	}

	public void setStudentVO(StudentVO studentVO) {
		this.studentVO = studentVO;
	}
	
	public String retrieveStudentList(String status) {
		RegistrationDAO registrationDAO = new RegistrationDAO();
		int statusId;
		if(StringUtils.equals(status, "active"))
		{
			statusId = 1;
			headerStr = "LIST OF CURRENT STUDENTS";
			statusChangeBtnVal = "Deactivate";
		} else if (StringUtils.equals(status, "waiting")) {
			statusId = 2;
			headerStr = "LIST OF WAITING STUDENTS";
			statusChangeBtnVal = "Activate";
		}else {
			statusId = 3;
			headerStr = "LIST OF INACTIVE STUDENTS";
			statusChangeBtnVal = "Activate";
		}
		currentStudList = registrationDAO.fetchStudentList(statusId);
		
		return null;
		
	}

	/**
	 * @return the currentStudList
	 */
	public List<RegistrationVO> getCurrentStudList() {
		return currentStudList;
	}

	/**
	 * @param currentStudList the currentStudList to set
	 */
	public void setCurrentStudList(List<RegistrationVO> currentStudList) {
		this.currentStudList = currentStudList;
	}

	/**
	 * @return the headerStr
	 */
	public String getHeaderStr() {
		return headerStr;
	}

	/**
	 * @param headerStr the headerStr to set
	 */
	public void setHeaderStr(String headerStr) {
		this.headerStr = headerStr;
	}

	/**
	 * @return the statusChangeBtnVal
	 */
	public String getStatusChangeBtnVal() {
		return statusChangeBtnVal;
	}

	/**
	 * @param statusChangeBtnVal the statusChangeBtnVal to set
	 */
	public void setStatusChangeBtnVal(String statusChangeBtnVal) {
		this.statusChangeBtnVal = statusChangeBtnVal;
	}
	

}
