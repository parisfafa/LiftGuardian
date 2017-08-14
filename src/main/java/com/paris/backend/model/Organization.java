package com.paris.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.paris.backend.constants.OrganizationType;
@Entity
@Table(name = "orgnization")
public class Organization{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="organization_id")
	private int id;
	
	@Column(name="organization_type")
	private String organizationType;
	
	@NotEmpty(message = "*Please provide an organization name")
	@Column(name="organization_name")
	private String organizationName;
	
	@NotEmpty(message = "*Please provide phone")
	@Column(name="phone")
	private String phone;
	
	@NotEmpty(message = "*Please provide an address")
	@Column(name="address")
	private String address;
	
	@Column(name = "email")
	@Email(message = "*Please provide a valid email")
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getOrganizationType() {
		return organizationType;
	}
	public void setOrganizationType(String organizationType) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
