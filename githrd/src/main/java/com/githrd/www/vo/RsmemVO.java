package com.githrd.www.vo;

import java.text.SimpleDateFormat;
import java.util.*;

public class RsmemVO {
	private String id, pw;
	private int mno;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	@Override
	public String toString() {
		return "RsmemVO [id=" + id + ", pw=" + pw + ", mno=" + mno + "]";
	}
	
	
	
}