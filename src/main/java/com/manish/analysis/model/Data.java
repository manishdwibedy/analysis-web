package com.manish.analysis.model;

import java.util.List;

public class Data {
	List<Metadata> metadata;
	List<TableData> data;
	
	public List<Metadata> getMetadata() {
		return metadata;
	}
	public void setMetadata(List<Metadata> metadata) {
		this.metadata = metadata;
	}
	public List<TableData> getData() {
		return data;
	}
	public void setData(List<TableData> data) {
		this.data = data;
	}
}
