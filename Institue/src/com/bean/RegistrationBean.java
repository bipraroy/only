package com.bean;

import com.VO.RegistrationVO;
import com.dao.RegistrationDAO;


public class RegistrationBean {
	private RegistrationVO registrationVO ;
	public RegistrationDAO registrationDao;
	
	public RegistrationBean()
	{
		registrationVO = new RegistrationVO();
		registrationDao = new RegistrationDAO();
	}
	
	
	public RegistrationVO getRegistrationVO() {
		return registrationVO;
	}


	public void setRegistrationVO(RegistrationVO registrationVO) {
		this.registrationVO = registrationVO;
	}


	public String createUser()
	{
		registrationDao.insertStudentProfile(registrationVO);
		System.out.println("Registration info : \n\n\n\n-----------"+registrationVO.toString());
		return null;
	}
}
