package com.bean;

import com.VO.StudentVO;

public class StudentBean {
	
	private StudentVO studentVO;
	
	public StudentBean() {
		studentVO = new StudentVO();
		System.out.println("Inside the student bean");
	}

	public StudentVO getStudentVO() {
		return studentVO;
	}

	public void setStudentVO(StudentVO studentVO) {
		this.studentVO = studentVO;
	}
	

}
