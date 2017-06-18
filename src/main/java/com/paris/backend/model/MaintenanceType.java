package com.paris.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name = "maintenance_type")
public class MaintenanceType {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="type_id")
	private int id;
	
	@NotEmpty(message = "*Please provide your maintenance type")
	@Column(name="maintenance_type")
	private String maintenanceType;

	public MaintenanceType() {
	}

	public MaintenanceType(String maintenanceType) {
		super();
		this.maintenanceType=maintenanceType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaintenanceType() {
		return maintenanceType;
	}

	public void setMaintenanceType(String maintenanceType) {
		this.maintenanceType = maintenanceType;
	}

}
