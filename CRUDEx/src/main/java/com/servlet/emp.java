package com.servlet;

import java.util.List;

public class emp {

	int id;
	String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

	public static List<emp> view() {
		// TODO Auto-generated method stub
		return null;
	}
	public emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public emp(int id2) {
		// TODO Auto-generated constructor stub
	}
	public emp() {
		// TODO Auto-generated constructor stub
	}
	
	}


