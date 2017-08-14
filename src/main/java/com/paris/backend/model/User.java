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

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "user")
public class User {

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;
	@Expose
	@Column(name = "active")
	private int active;
	@Expose
	@Column(name = "email")
	@Email(message = "*Please provide a valid email")
	@NotEmpty(message = "*Please provide an email")
	private String email;
	@Expose
	@Column(name = "name")
	@NotEmpty(message = "*Please provide your name")
	private String name;
	@Expose
	@Column(name = "last_name")
	@NotEmpty(message = "*Please provide your last name")
	private String lastName;
	@Expose
	@Column(name = "phone")
	@NotEmpty(message = "*Please provide your contact number")
	private String phone;
	@Expose
	@Column(name = "password")
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@Transient
	private String password;
	@Expose
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval=true,fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Role role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("User{");
		sb.append("id=").append(id);
		sb.append(", active=").append(active);
		sb.append(", email='").append(email).append('\'');
		sb.append(", name='").append(name).append('\'');
		sb.append(", lastName='").append(lastName).append('\'');
		sb.append(", phone='").append(phone).append('\'');
		sb.append(", password='").append(password).append('\'');
		sb.append(", role=").append(role);
		sb.append('}');
		return sb.toString();
	}
}