package com.max.model;

public class Worker {
	
	public Worker(int w_id, String w_name, String w_phone, String w_pro, String w_flag) {
		super();
		this.w_id = w_id;
		this.w_name = w_name;
		this.w_phone = w_phone;
		this.w_pro = w_pro;
		this.w_flag = w_flag;
	}
	
	public Worker() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int w_id;
	private String w_name;
	private String w_phone;
	private String w_pro;
	private String w_flag;
	
	public String getW_name() {
		return w_name;
	}
	public void setW_name(String w_name) {
		this.w_name = w_name;
	}
	public String getW_phone() {
		return w_phone;
	}
	public void setW_phone(String w_phone) {
		this.w_phone = w_phone;
	}
	public String getW_pro() {
		return w_pro;
	}
	public void setW_pro(String w_pro) {
		this.w_pro = w_pro;
	}
	public String getW_flag() {
		return w_flag;
	}
	public void setW_flag(String w_flag) {
		this.w_flag = w_flag;
	}
}
