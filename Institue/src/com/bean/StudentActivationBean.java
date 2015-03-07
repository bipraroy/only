package com.bean;

import javax.faces.context.FacesContext;

import com.VO.RegistrationVO;
import com.dao.RegistrationDAO;

public class StudentActivationBean {
	
	private RegistrationVO registrationVO = new RegistrationVO();
	private String statusChangeBtnVal = null;
	
	public StudentActivationBean() {
		/*currentStudList = retrieveStudentList(null);*/
		retrieveStudentDetails();
		System.out.println("Inside the StudentActivationBean");
	}

	
	private void retrieveStudentDetails() {
		
		String regId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("regId");
		statusChangeBtnVal = "Activate";
		System.out.println("Registration Id :: "+regId);
		RegistrationDAO registrationDAO = new RegistrationDAO();
		registrationVO = registrationDAO.fetchStudentDetails(regId);
		
	}

	public String statusChange() {
		String regId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("regId");
		String statusId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("statusId");
		
		System.out.println("RegID: "+regId+" Stat Id: "+statusId);
		
		RegistrationDAO registrationDAO = new RegistrationDAO();
		registrationDAO.updateStudentStatus(regId, statusId);
		
		return null;
	}

	/**
	 * @return the registrationVO
	 */
	public RegistrationVO getRegistrationVO() {
		return registrationVO;
	}


	/**
	 * @param registrationVO the registrationVO to set
	 */
	public void setRegistrationVO(RegistrationVO registrationVO) {
		this.registrationVO = registrationVO;
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
