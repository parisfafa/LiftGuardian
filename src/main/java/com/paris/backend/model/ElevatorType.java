package com.paris.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name = "elevator_type")
public class ElevatorType {
	@Expose
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="type_id")
	private int id;

	@Expose
	@NotEmpty(message = "*Please provide your elevator type")
	@Column(name="elevator_type")
	private String elevatorType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getElevatorType() {
		return elevatorType;
	}

	public void setElevatorType(String elevatorType) {
		this.elevatorType = elevatorType;
	}

	

	
}
