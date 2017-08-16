package com.paris.backend.model;

import com.google.gson.annotations.Expose;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "elevator_model")
public class ElevatorModel {
	@Expose
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="model_id")
	private int id;

	@Expose
	@Column(name="elevator_model")
	private String elevatorModel;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getElevatorModel() {
		return elevatorModel;
	}
	public void setElevatorModel(String elevatorModel) {
		this.elevatorModel = elevatorModel;
	}

	public ElevatorModel() {
	}
}
