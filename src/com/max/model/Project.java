package com.max.model;
/**
 * ��������Ŀ����
 */

import java.sql.Date;

public class Project {
	private int p_id;//��Ŀ�ı��
	private String p_wname;//��Ŀ����
	private String p_dsp;//��Ŀ������description��
	private String p_sit;//��Ŀ״����situation�����Ա������ն����ˣ�
	private Date p_bedate;//
	private Date p_endate;//
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_wname() {
		return p_wname;
	}
	public void setP_wname(String p_wname) {
		this.p_wname = p_wname;
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
	public Date getP_bedate() {
		return p_bedate;
	}
	public void setP_bedate(Date p_bedate) {
		this.p_bedate = p_bedate;
	}
	public Date getP_endate() {
		return p_endate;
	}
	public void setP_endate(Date p_endate) {
		this.p_endate = p_endate;
	}
}
