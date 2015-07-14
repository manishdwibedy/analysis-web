package com.manish.analysis.util;

public class Util {
	private static String[] baseColumns = new String[]{"code","description","unit","quantity","price"};
	private static String[] itemColumns = new String[]{"code","description","unit","quantity","price","action"};

	public static String[] getItemColumns() {
		return itemColumns;
	}

	public static String[] getBaseColumns() {
		return baseColumns;
	}
}
