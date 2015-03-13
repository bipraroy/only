package com.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import com.VO.LoginVO;
import com.dao.LoginDAO;
import com.util.User;

public class LoginBean {
	private LoginVO loginVO ;
	public LoginDAO loginDAO;
	public LoginBean()
	{
		loginVO=new LoginVO();
		loginDAO=new LoginDAO();

	}
	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
	public String createLogin()
	{
		String actionStr = null;
		User user  = loginDAO.cheaking(loginVO);

		System.out.println("User type "+user.getUserType());
		if(user.getUserType() != null)
		{
			if(user.getUserType().equals("admin"))
			{
				actionStr = "admin";
				System.out.println("Admin login succesful");
			}
			else if(user.getUserType().equals("student"))
			{
				String status = loginDAO.getStudentStatus(user.getStatusId());
				System.out.println("Status "+status);
				if(status.equals("waiting")){
					System.out.println("Required admin activation");
				FacesContext.getCurrentInstance().addMessage(null, new javax.faces.application.FacesMessage(FacesMessage.SEVERITY_ERROR,"Required Admin Activation", null));
				}else if(status.equals("active"))
				{
					actionStr="student";
					System.out.println("Succesfully login");
				}
				else if(status.equals("deactive"))
					System.out.println("Currently you are deactive");
			}
		}else{
			
			System.out.println("User id or password incorrect");
			FacesContext.getCurrentInstance().addMessage(null, new javax.faces.application.FacesMessage(FacesMessage.SEVERITY_ERROR,"please enter a valid username or password", null));
			this.loginVO.setUserName("");
			this.loginVO.setPassword("");
		}
		System.out.println("login info:"+loginVO.toString());
		return actionStr;

	}	

}


