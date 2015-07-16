package com.manish.analysis.model;

public class BasicRateJson{
	protected String code;
	protected String description;
	protected String unit;
	protected float quantity;
	protected float price;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public BasicRateJson()
	{
		code = null;
		description = null;
		unit = null;
	}
	
	@Override
	public String toString() {
		return "Material [code=" + code + ", description=" + new String(description)
				+ ", unit=" + unit + ", price=" + price + "]";
	}
	
	
}
