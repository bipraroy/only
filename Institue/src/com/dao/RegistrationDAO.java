package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.VO.RegistrationVO;
import com.util.DBHelper;

public class RegistrationDAO {


	public int insertStudentProfile( RegistrationVO registrationVO)
	{
		int result=0;
		int statusId  = getStatusId();
		int typeId = getTypeId();
		int userId = insertIntoUser(registrationVO,statusId,typeId);
		Connection con=DBHelper.getConnection();
		PreparedStatement ps=null;
		if(userId!=0){
		String sql="insert into t_user_profile(user_id,first_name,middle_name,last_name,gurdain_name,dob,address,city,zip_code,state,country,contact_no,gurdain_contact_no,last_exam_name,last_exam_marks,board_name)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try{
			ps=con.prepareStatement(sql);
			ps.setInt(1,userId);
			ps.setString(2,registrationVO.getFirstName());
			ps.setString(3,registrationVO.getMiddleName());
			ps.setString(4,registrationVO.getLastName());
			ps.setString(5,registrationVO.getGurdainName());
			ps.setInt(6, registrationVO.getDob());
			ps.setString(7, registrationVO.getAddress());
			ps.setString(8, registrationVO.getCity());
			ps.setInt(9,registrationVO.getZipCode());
			ps.setString(10,registrationVO.getState());
			ps.setString(11,registrationVO.getCountry());
			ps.setInt(12,registrationVO.getContactNo());
			ps.setInt(13,registrationVO.getGurdainContactNo());
			ps.setString(14,registrationVO.getLastExamName());
			ps.setString(15,registrationVO.getLastExamMarks());
			ps.setString(16,registrationVO.getBoardName());
			result = ps.executeUpdate();
			System.out.println("result"+result);
	
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else{
			System.out.println("database not created sucessesfully");
		}
		return result;

	}
	private int  insertIntoUser(RegistrationVO registrationVO, int statusId,
			int typeId) {
		int userId   = 0;
		Connection con = DBHelper.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into t_user(username,password,type_id,status_id,created_at) values(?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, registrationVO.getEmailId());
			ps.setString(2, registrationVO.getPassword());
			ps.setInt(3, typeId);
			ps.setInt(4, statusId);
			ps.setString(5,"05/01/2015");
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next())
				userId = rs.getInt(1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Succesfully inserted into user with userid   "+userId);
		return userId;

	}
	public int getTypeId() {
		int typeId = 0;
		Connection con = DBHelper.getConnection();
		PreparedStatement ps = null;
		String sql = "select type_id from t_user_type where type_name=?";
		try {
			ps  = con.prepareStatement(sql);
			ps.setString(1, "student");
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				typeId = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Succesfully getting type_id   "+typeId);
		return typeId;

	}

	public int getStatusId() {
		int statusId = 0;
		Connection con = DBHelper.getConnection();
		PreparedStatement ps = null;
		String sql = "select status_id from t_user_status where status_name=? ";
		try {
			ps  = con.prepareStatement(sql);
			ps.setString(1, "waiting");
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				statusId = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Succesfully getting status_id  "+statusId);
		return statusId;	
	}
}