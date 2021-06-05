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
		StringBuffer sb =new StringBuffer("select * from worker");
		if (StringUtil.isNotEmpty(worker.getW_pro())) {
			sb.append(" and p_name like '%"+worker.getW_pro()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
}
}
