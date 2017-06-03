package com.paris.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.paris.backend.constants.OrganizationType;
@Entity
@Table(name = "orgnization")
public class Organization{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="organization_id")
	private int id;
	@Column(name="organization_type")
	private OrganizationType organizationType;
	@Column(name="organization_name")
	private String organizationName;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="address")
	private String address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public OrganizationType getOrganizationType() {
		return organizationType;
	}
	public void setOrganizationType(OrganizationType organizationType) {
		this.organizationType = organizationType;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
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

}
