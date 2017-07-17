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
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name = "device")
public class Device {
	@Id
	@Digits(integer=10, fraction=0) 
	@Min(value = 1) 
	@Column(name="deviceid")
	private Long id;
	
	@NotEmpty(message = "*Please provide an device name")
	@Column(name="device_name")
	private String deviceName;
	
	@NotEmpty(message = "*Please provide an address")
	@Column(name="address")
	private String address;
	
	@NotEmpty(message = "*Please provide an post code")
	@Column(name="postcode")
	private String postcode;
	
	@Column(name="country")
	private String country="SG";
	


	@OneToOne(cascade = CascadeType.MERGE,orphanRemoval=true,fetch = FetchType.EAGER)

	@JoinTable(name = "device_type", joinColumns = @JoinColumn(name = "deviceid"), inverseJoinColumns = @JoinColumn(name = "type_id"))
	private ElevatorType elevatorType;

	@OneToOne(cascade = CascadeType.MERGE,orphanRemoval=true,fetch = FetchType.EAGER)
	@JoinTable(name = "device_camera", joinColumns = @JoinColumn(name = "deviceid"), inverseJoinColumns = @JoinColumn(name = "cameraid"))
	private Camera camera;
	
	@OneToOne(cascade = CascadeType.MERGE,orphanRemoval=true,fetch = FetchType.EAGER)
	@JoinTable(name = "device_model", joinColumns = @JoinColumn(name = "deviceid"), inverseJoinColumns = @JoinColumn(name = "model_id"))
	private ElevatorModel elevatorModel;
	
	@OneToOne(cascade = CascadeType.MERGE,orphanRemoval=true,fetch = FetchType.EAGER)
	@JoinTable(name = "device_manufacturer", joinColumns = @JoinColumn(name = "deviceid"), inverseJoinColumns = @JoinColumn(name = "manufacturer_id"))
	private Manufacturer manufacturer;
	
	@OneToOne(cascade = CascadeType.MERGE,orphanRemoval=true,fetch = FetchType.EAGER)
	@JoinTable(name = "device_organization", joinColumns = @JoinColumn(name = "deviceid"), inverseJoinColumns = @JoinColumn(name = "organization_id"))
	private Organization organization;



	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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



	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
