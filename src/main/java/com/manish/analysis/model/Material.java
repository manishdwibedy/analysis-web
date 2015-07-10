package com.manish.analysis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Material{
	@Id
    @GeneratedValue
	protected int id;
	protected String code;
	protected byte[] description;
	protected String unit;
	protected float quantity;
	protected float price;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public byte[] getDescription() {
		return description;
	}
	public void setDescription(byte[] description) {
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
	
	@Override
    public Object clone() throws CloneNotSupportedException {
		return super.clone();
    }
	
	public Material()
	{
		code = null;
		description = new byte[1];
		unit = null;
	}
	
	@Override
	public String toString() {
		return "Material [code=" + code + ", description=" + new String(description)
				+ ", unit=" + unit + ", price=" + price + "]";
	}
	
	
}
