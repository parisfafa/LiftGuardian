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

@Entity
@Table(name = "tb_record")
public class Record {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="recordId")
	private int id;
	@Column(name="deviceId")
	private String deviceId;
	@Column(name="createTime")
	private String createTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	/*public ElevatorStatus getElevatorStatus() {
		return elevatorStatus;
	}
	public void setElevatorStatus(ElevatorStatus elevatorStatus) {
		this.elevatorStatus = elevatorStatus;
	}*/

}
