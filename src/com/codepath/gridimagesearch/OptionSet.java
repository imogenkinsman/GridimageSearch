package com.codepath.gridimagesearch;

import java.io.Serializable;

public class OptionSet implements Serializable {
	private static final long serialVersionUID = 2087823728917989839L;
	private String size;
	private String color;
	private String type;
	private String filter;
	
	public OptionSet(String size, String color, String type, String filter) {
		this.size = size;
		this.color = color;
		this.type = type;
		this.filter = filter;
	}
	
	public String getSize() {
		return size;
	}
	public String getColor() {
		return color;
	}
	public String getType() {
		return type;
	}
	public String getFilter() {
		return filter;
	}
}
