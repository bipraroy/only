package com.bean;

import java.util.ArrayList;
import java.util.List;

import com.VO.RegistrationVO;
import com.VO.StudentVO;
import com.dao.RegistrationDAO;

public class StudentBean {
	
	private StudentVO studentVO;
	private List<RegistrationVO> currentStudList = new ArrayList<RegistrationVO>();
	
	public StudentBean() {
		studentVO = new StudentVO();
		currentStudList = retrieveStudentList(null);
		System.out.println("Inside the student bean");
	}

	public StudentVO getStudentVO() {
		return studentVO;
	}

	public void setStudentVO(StudentVO studentVO) {
		this.studentVO = studentVO;
	}
	
	public List<RegistrationVO> retrieveStudentList(String status) {
		List<RegistrationVO> studentList = new ArrayList<RegistrationVO>();
		RegistrationDAO registrationDAO = new RegistrationDAO();
		studentList = registrationDAO.fetchStudentDetails(null);
		
		RegistrationVO vo = studentList.get(0);
		vo.setRegistrationId("SB-CHM-111");
		
		studentList.clear();
		studentList.add(vo);
		studentList.add(vo);
		studentList.add(vo);
		studentList.add(vo);
		studentList.add(vo);
		studentList.add(vo);
		studentList.add(vo);
		studentList.add(vo);
		studentList.add(vo);
		studentList.add(vo);
		
		return studentList;
		
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
	

}
