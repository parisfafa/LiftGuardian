package com.paris.backend.secondaryModel;

import com.google.gson.annotations.Expose;

import javax.persistence.*;

@Entity
@Table(name = "tb_record")
public class Record {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="recordid")
	private int id;
	@Column(name="deviceid")
	private String deviceid;
	@Column(name="createtime")
	private String createtime;

	@Expose
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval=true,fetch = FetchType.EAGER)
	@JoinColumn(name = "recordid")
	private ElevatorStatus elevatorStatus;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDeviceid() {
		return deviceid;
	}
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="recordid")
	public ElevatorStatus getElevatorStatus() {
		return elevatorStatus;
	}
	public void setElevatorStatus(ElevatorStatus elevatorStatus) {
		this.elevatorStatus = elevatorStatus;
	}

}
