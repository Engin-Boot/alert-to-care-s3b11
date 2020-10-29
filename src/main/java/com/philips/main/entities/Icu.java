package com.philips.main.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "icu_info")
public class Icu {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "icu_Id")
	private int icuId;
	
	@Column(name = "layout")
	private String layout;
    
	@Column(name = "icu_Maximum_Capacity")
	private int icuMaximumCapacity;
	
	public Icu() {
		
	}

	public Icu(int icuId, String layout, int icuMaximumCapacity) {
		super();
		this.icuId = icuId;
		this.layout = layout;
		this.icuMaximumCapacity = icuMaximumCapacity;
	}

	public int getIcuId() {
		return icuId;
	}

	public void setIcuId(int icuId) {
		this.icuId = icuId;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public int getIcuMaximumCapacity() {
		return icuMaximumCapacity;
	}

	public void setIcuMaximumCapacity(int icuMaximumCapacity) {
		this.icuMaximumCapacity = icuMaximumCapacity;
	}
	
	

}