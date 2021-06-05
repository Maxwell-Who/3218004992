package com.max.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.max.model.Worker;
import com.maxwell.util.StringUtil;


public class WorkerDao {
	/**
	 * 查询自由职业者
	 * @param con
	 * @param worker
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,Worker worker) throws Exception{
		StringBuffer sb =new StringBuffer("select * from worker where w_flag='1'");
		if (StringUtil.isNotEmpty(worker.getW_pro())) {
			sb.append(" and w_pro like '%"+worker.getW_pro()+"%' ");
		}
		//PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		//System.out.println(sb);
		return pstmt.executeQuery();
}
}
