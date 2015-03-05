package com.bean;

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
		if(user.getUserType().equals("admin"))
		{
			actionStr = "admin";
			System.out.println("Admin login succesful");
		}
		else if(user.getUserType().equals("student"))
		{
			String status = loginDAO.getStudentStatus(user.getStatusId());
			System.out.println("Status "+status);
			if(status.equals("waiting"))
				System.out.println("Required admin activation");
			else if(status.equals("active"))
				System.out.println("Succesfully login");
			else if(status.equals("deactive"))
				System.out.println("Currently you are deactive");
		}
		else
			System.out.println("User id or password incorrect");
		System.out.println("login info:"+loginVO.toString());
		return actionStr;

	}	

}


