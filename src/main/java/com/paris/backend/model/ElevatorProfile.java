package com.paris.backend.model;

import com.google.gson.annotations.Expose;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "elevatorprofile")
public class ElevatorProfile {
	@Expose
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;

}
