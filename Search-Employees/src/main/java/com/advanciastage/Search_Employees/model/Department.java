package com.advanciastage.Search_Employees.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Departments")
public class Department {
	@Id
	@Column(name = "DEPARTMENT_ID")
	private Long id;
	@Column(name ="DEPARTMENT_NAME")
	private String Department_name;
	@ManyToOne
	@JoinColumn(name="LOCATION_ID")
	private Location location;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDepartment_name() {
		return Department_name;
	}
	public void setDepartment_name(String department_name) {
		Department_name = department_name;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	
}
