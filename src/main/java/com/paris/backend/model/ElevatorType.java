package com.paris.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name = "elevator_type")
public class ElevatorType {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="type_id")
	private int id;
	
	@NotEmpty(message = "*Please provide your elevator type")
	@Column(name="elevator_type")
	private String elevatorTypeName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getElevatorTypeName() {
		return elevatorTypeName;
	}

	public void setElevatorTypeName(String elevatorTypeName) {
		this.elevatorTypeName = elevatorTypeName;
	}

	
}
