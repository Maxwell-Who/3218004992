package com.max.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.max.model.Project;
import com.maxwell.util.StringUtil;

/**
 * ��Ŀ���ݲ�����
 * @author lan
 *
 */
public class ProjectDao {
	/**
	 * �����Ŀ
	 * @param con
	 * @param project
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,Project project)throws Exception{
		String sql="insert into project values(null,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		//pstmt.setInt(1, project.getP_id());  //ID��Ϊ������ ���û�ȡ
		pstmt.setString(1, project.getP_wname());
		pstmt.setString(2, project.getP_name());
		pstmt.setString(3, project.getP_dsp());
		pstmt.setString(4, project.getP_sit());
		//pstmt.setDate(5, project.getP_bedate());
		//pstmt.setDate(6, project.getP_endate());

		return pstmt.executeUpdate();
	}
	
	/**
	 * ��ѯ��Ŀ���
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
