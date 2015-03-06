package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.VO.LoginVO;
import com.util.DBHelper;
import com.util.User;

public class LoginDAO {

	public User cheaking(LoginVO loginVO) {
		Connection con = DBHelper.getConnection();
		PreparedStatement ps = null;
		int typeId = 0;
		int statusId = 0;
		String typeName = null;
		User user = new User();
		String sql = "select * from institute_db.t_user where username=? and password=?";
		try {
			ps  = con.prepareStatement(sql);
			ps.setString(1,loginVO.getUserName());
			ps.setString(2,loginVO.getPassword());
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				typeId = rs.getInt("type_id");
				statusId = rs.getInt("status_id");
				typeName = getTypeName(typeId);
				user.setStatusId(statusId);
				user.setUserType(typeName);
				System.out.println("user name & password is correct");
			}else{
				System.out.println("username is wrong");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
	return user;
	}

	private String getTypeName(int typeId) {
		
		Connection con = DBHelper.getConnection();
		PreparedStatement ps = null;
		String typeName = null;
		String sql = "select type_name from t_user_type where type_id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, typeId);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				typeName = rs.getString(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return typeName;
		
	}
	
	public String getStudentStatus(int statusId)
	{
		Connection con = DBHelper.getConnection();
		PreparedStatement ps = null;
		String statusName = null;
		String sql = "select status_name from t_user_status where status_id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1,statusId);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				statusName = rs.getString(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return statusName;
		
	}
	
	}
	
	

