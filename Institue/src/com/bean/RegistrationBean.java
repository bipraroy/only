package com.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

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
		String actionStr=null;
		if((registrationVO.getFirstName().equals(""))|| (registrationVO.getMiddleName().equals(""))
				   || (registrationVO.getLastName().equals("")) || (registrationVO.getGurdainName().equals("")) || (registrationVO.getDob().equals(""))
				   || (registrationVO.getAddress().equals("")) ||  (registrationVO.getCity().equals(""))
				   || (registrationVO.getZipCode()==0) || (registrationVO.getState().equals("")) || (registrationVO.getCountry().equals(""))
		           || (registrationVO.getContactNo()==0) || (registrationVO.getGurdainContactNo()==0) || (registrationVO.getLastExamName().equals(""))
		           || (registrationVO.getLastExamMarks().equals("")) || (registrationVO.getBoardName().equals("")))
				   {
			System.out.println("Inside else part");
			FacesContext.getCurrentInstance().addMessage(null, new javax.faces.application.FacesMessage(FacesMessage.SEVERITY_ERROR,"PLEASE FILLUP ALL MANDATORY FIELD", null));
				}else{
					
					registrationDao.insertStudentProfile(registrationVO);
					actionStr ="registered";
				    FacesContext.getCurrentInstance().addMessage(null, new javax.faces.application.FacesMessage(FacesMessage.SEVERITY_INFO,"REGISTRATION SUCCESSFULLY", null));
				}
		
		
		System.out.println("Registration info : \n\n\n\n-----------"+registrationVO.toString());
		return actionStr;
	}
}
