package com.max.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.max.model.Schedule;
import com.maxwell.util.StringUtil;

public class ScheduleDao {
	public ResultSet list(Connection con,Schedule schedule)throws Exception{
		StringBuffer sb=new StringBuffer("select * from schedule");
		if (StringUtil.isNotEmpty(schedule.getS_time())) {
			System.out.println(schedule.getS_time());
			sb.append(" and s_time like '%"+schedule.getS_time()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
}
