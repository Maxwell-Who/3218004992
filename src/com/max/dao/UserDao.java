package com.max.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.max.model.User;

/**
 * dao class of user
 * @author lan
 *
 */
public class UserDao {
	public User login(Connection con,User user)throws Exception{
		User resultUser=null;
		String sql="select * from worker where w_name=? and w_password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,user.getUserName());
		pstmt.setString(2,user.getPassword());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			resultUser=new User();
			resultUser.setId(rs.getInt("w_id"));
			resultUser.setUserName(rs.getNString("w_name"));
			resultUser.setPassword(rs.getString("w_password"));
		}
		
		return resultUser;
	}
}
