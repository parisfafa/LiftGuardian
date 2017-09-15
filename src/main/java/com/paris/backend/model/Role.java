package com.paris.backend.model;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
@Entity
@Table(name = "role")
public class Role {
	@Expose
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="role_id")
	private int id;
	@Expose
	@Column(name="role")
	private String role;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Role{");
		sb.append("id=").append(id);
		sb.append(", role='").append(role).append('\'');
		sb.append('}');
		return sb.toString();
	}
}