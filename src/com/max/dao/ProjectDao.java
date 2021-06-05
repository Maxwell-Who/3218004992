package com.max.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.max.model.Project;
import com.maxwell.util.StringUtil;

/**
 * 项目数据操作类
 * @author lan
 *
 */
public class ProjectDao {
	/**
	 * 添加项目
	 * @param con
	 * @param project
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,Project project)throws Exception{
		String sql="insert into project values(null,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		//pstmt.setInt(1, project.getP_id());  //ID改为了自增 不用获取
		pstmt.setString(1, project.getP_wname());
		pstmt.setString(2, project.getP_name());
		pstmt.setString(3, project.getP_dsp());
		pstmt.setString(4, project.getP_sit());
		//pstmt.setDate(5, project.getP_bedate());
		//pstmt.setDate(6, project.getP_endate());

		return pstmt.executeUpdate();
	}
	
	/**
	 * 查询项目类别
	 * @param con
	 * @param p_wname
	 * @param p_name
	 * @param p_dsp
	 * @param p_sit
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,Project project) throws Exception{
			StringBuffer sb =new StringBuffer("select * from project");
			if (StringUtil.isNotEmpty(project.getP_name())) {
				//System.out.println(project.getP_name()); 
				sb.append(" and p_name like '%"+project.getP_name()+"%'");
			}
			PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
			return pstmt.executeQuery();
	}
}
