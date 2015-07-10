package com.manish.analysis.model;

import com.google.gson.Gson;

public class GenericModel {

	private String[][] data;
	
	
	public String[][] getData() {
		return data;
	}

	public void setData(String[][] data) {
		this.data = data;
	}

	// Just testing...
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		a.data = new String[2][5];
		a.data[0] = new String[]{"Tiger Nixon","System Architect","Edinburgh","5421","2011/04/25"};
		a.data[1] = new String[]{"Tiger Nixon","System Architect","Edinburgh","5421","2011/04/25"};
		
		System.out.println(new Gson().toJson(a));

	}
	
	static class A{
		String[][] data;
	}
}
