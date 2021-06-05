package com.max.model;

public class Schedule {
	
	
	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Schedule(String s_name, String s_time, String s_mark) {
		super();
		this.s_name = s_name;
		this.s_time = s_time;
		this.s_mark = s_mark;
	}
	
	private String s_name;
	private String s_time;
	private String s_mark;
	
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_time() {
		return s_time;
	}
	public void setS_time(String s_time) {
		this.s_time = s_time;
	}
	public String getS_mark() {
		return s_mark;
	}
	public void setS_mark(String s_mark) {
		this.s_mark = s_mark;
	}
	
}
