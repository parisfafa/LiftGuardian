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

}
