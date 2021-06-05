package com.max.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.max.model.Custormer;
import com.maxwell.util.StringUtil;


public class CustormerDao {

	public ResultSet list(Connection con,Custormer custormer) throws Exception{
		StringBuffer sb =new StringBuffer("select * from worker where w_flag='3'");
		if (StringUtil.isNotEmpty(custormer.getW_pro())) {
			sb.append(" and w_pro like '%"+custormer.getW_pro()+"%' ");
			System.out.println(sb);
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
}
}
