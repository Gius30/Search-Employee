package com.advanciastage.Search_Employees.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "REGIONS")
public class Regions {
	@Id
	@Column(name = "REGION_ID")
	private Long id;
	
	@Column(name = "REGION_NAME")
	private String region_name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegion_name() {
		return region_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	
	
}
