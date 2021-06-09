package com.max.model;
/**
 * 这里是项目
 */


public class Project {
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Project(String p_name, String p_dsp, String p_sit, String p_wname) {
		super();
		this.p_wname = p_wname;
		this.p_name = p_name;
		this.p_dsp = p_dsp;
		this.p_sit = p_sit;
	}



	private int p_id;//项目的编号
	private String p_name;//项目名称
	private String p_dsp;//项目描述（description）
	private String p_sit;//项目状况（situation）用以表明招收多少人？
	private String p_wname;//项目上传人名称

	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_dsp() {
		return p_dsp;
	}
	public void setP_dsp(String p_dsp) {
		this.p_dsp = p_dsp;
	}
	public String getP_sit() {
		return p_sit;
	}
	public void setP_sit(String p_sit) {
		this.p_sit = p_sit;
	}
	public String getP_wname() {
		return p_wname;
	}
	public void setP_wname(String p_wname) {
		this.p_wname = p_wname;
	}

	
}
