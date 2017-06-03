package com.paris.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name = "alarm_type")
public class AlarmType {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="alarm_id")
	private int id;
	
	@NotEmpty(message = "*Please provide your elevator type")
	@Column(name="alarm_type")
	private String alarmType;

	public AlarmType() {
	}

	public AlarmType(String alarmType) {
		super();
		this.alarmType = alarmType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlarmType() {
		return alarmType;
	}

	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}
	
}
