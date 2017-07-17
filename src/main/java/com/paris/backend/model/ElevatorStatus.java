package com.paris.backend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name = "tb_elevatorstatus")
public class ElevatorStatus {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="recordid")
	private int id;
	
	@Column(name="rtuid")
	private String rtuid;
	
	
	@Column(name="sendtime")
	private String sendtime;
	
	@Column(name="datatime")
	private String datatime;

	@Expose
	@Column(name="floor")
	private String floor;

	@Expose
	@Column(name="rundirection")
	private String rundirection;

	@Expose
	@Column(name="bodystatus")
	private String bodystatus;

	@Expose
	@Column(name="doorstatus")
	private String doorstatus;

	@Column(name="sensorstatus")
	private String sensorstatus;

	@Expose
	@Column(name="elevatorspeed")
	private String elevatorspeed;
	
	@Column(name="midstop")
	private String midstop;
	
	@Column(name="trap")
	private String trap;
	
	@Column(name="Illegalopen")
	private String Illegalopen;
	
	@Column(name="elevatorOverup")
	private String elevatorOverup;
	
	@Column(name="mp")
	private String mp;
	
	@Column(name="bp")
	private String bp;
	
	
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval=true,fetch = FetchType.EAGER)
	@JoinColumn(name = "recordid")
	private Record record;
	
	public ElevatorStatus() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRtuid() {
		return rtuid;
	}

	public void setRtuid(String rtuid) {
		this.rtuid = rtuid;
	}

	public String getSendtime() {
		return sendtime;
	}

	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

	public String getDatatime() {
		return datatime;
	}

	public void setDatatime(String datatime) {
		this.datatime = datatime;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getRundirection() {
		return rundirection;
	}

	public void setRundirection(String rundirection) {
		this.rundirection = rundirection;
	}

	public String getBodystatus() {
		return bodystatus;
	}

	public void setBodystatus(String bodystatus) {
		this.bodystatus = bodystatus;
	}

	public String getDoorstatus() {
		return doorstatus;
	}

	public void setDoorstatus(String doorstatus) {
		this.doorstatus = doorstatus;
	}

	public String getSensorstatus() {
		return sensorstatus;
	}

	public void setSensorstatus(String sensorstatus) {
		this.sensorstatus = sensorstatus;
	}

	public String getElevatorspeed() {
		return elevatorspeed;
	}

	public void setElevatorspeed(String elevatorspeed) {
		this.elevatorspeed = elevatorspeed;
	}

	public String getMidstop() {
		return midstop;
	}

	public void setMidstop(String midstop) {
		this.midstop = midstop;
	}

	public String getTrap() {
		return trap;
	}

	public void setTrap(String trap) {
		this.trap = trap;
	}

	public String getIllegalopen() {
		return Illegalopen;
	}

	public void setIllegalopen(String illegalopen) {
		Illegalopen = illegalopen;
	}

	public String getElevatorOverup() {
		return elevatorOverup;
	}

	public void setElevatorOverup(String elevatorOverup) {
		this.elevatorOverup = elevatorOverup;
	}

	public String getMp() {
		return mp;
	}

	public void setMp(String mp) {
		this.mp = mp;
	}

	public String getBp() {
		return bp;
	}

	public void setBp(String bp) {
		this.bp = bp;
	}

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

}
