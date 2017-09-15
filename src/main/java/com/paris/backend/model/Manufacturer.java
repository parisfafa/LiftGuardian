package com.paris.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "manufacturer")
public class Manufacturer {
	@Expose
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="manufacturer_id")
	private int id;

	@Expose
	@NotEmpty(message = "*Please provide your manufacturer name")
	@Column(name="manufacturer_name")
	private String manufacturerName;

	@Expose
	@Column(name="phone")
	private String phone;

	@Expose
	@Column(name="address")
	private String address;

	@Expose
	@Column(name="description")
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
