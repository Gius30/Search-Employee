package com.advanciastage.Search_Employees.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="COUNTRIES")
public class Countries {
	
	@Id
	@Column(name ="COUNTRY_ID")
	private Long id;
	
	@Column(name="COUNTRY_NAME")
	private String country_name;
	
	@ManyToOne
	@JoinColumn(name ="REGIONS")
	private Regions regions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public Regions getRegions() {
		return regions;
	}

	public void setRegions(Regions regions) {
		this.regions = regions;
	}
	
	
}
