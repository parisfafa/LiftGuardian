package com.paris.backend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name = "device")
public class Device {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="deviceid")
	private int id;
	
	@Column(name="device_name")
	private String deviceName;
	
	/*@OneToOne(cascade = CascadeType.ALL,orphanRemoval=true,fetch = FetchType.EAGER)
	@JoinTable(name = "tb_record", joinColumns = @JoinColumn(name = "deviceid"), inverseJoinColumns = @JoinColumn(name = "recordid"))
	private ElevatorStatus elevatorStatus;*/
	
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

	/*public ElevatorStatus getElevatorStatus() {
		return elevatorStatus;
	}

	public void setElevatorStatus(ElevatorStatus elevatorStatus) {
		this.elevatorStatus = elevatorStatus;
	}*/
	
}
