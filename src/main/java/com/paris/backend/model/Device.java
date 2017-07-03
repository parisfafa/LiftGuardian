package com.paris.backend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name = "device")
public class Device {
	@Id
	@Column(name="deviceid")
	private int id;
	
	@Column(name="device_name")
	private String deviceName;
	
	@Column(name="address")
	private String address;
	
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval=true,fetch = FetchType.EAGER)
	@JoinTable(name = "device_type", joinColumns = @JoinColumn(name = "deviceid"), inverseJoinColumns = @JoinColumn(name = "type_id"))
	private ElevatorType elevatorType;
	
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval=true,fetch = FetchType.EAGER)
	@JoinTable(name = "device_model", joinColumns = @JoinColumn(name = "deviceid"), inverseJoinColumns = @JoinColumn(name = "model_id"))
	private ElevatorModel elevatorModel;
	
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval=true,fetch = FetchType.EAGER)
	@JoinTable(name = "device_manufacturer", joinColumns = @JoinColumn(name = "deviceid"), inverseJoinColumns = @JoinColumn(name = "manufacturer_id"))
	private Manufacturer manufacturer;
	
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval=true,fetch = FetchType.EAGER)
	@JoinTable(name = "device_organization", joinColumns = @JoinColumn(name = "deviceid"), inverseJoinColumns = @JoinColumn(name = "organization_id"))
	private Organization organization;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ElevatorType getElevatorType() {
		return elevatorType;
	}

	public void setElevatorType(ElevatorType elevatorType) {
		this.elevatorType = elevatorType;
	}

	public ElevatorModel getElevatorModel() {
		return elevatorModel;
	}

	public void setElevatorModel(ElevatorModel elevatorModel) {
		this.elevatorModel = elevatorModel;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
}
