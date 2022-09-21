package com.registronacional.request.firmaestandar;

public class Educacion {

	 public String key;
	 public String value;
	public Educacion(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	public Educacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Educacion [key=");
		builder.append(key);
		builder.append(", value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}
	    
	 
	    
}
