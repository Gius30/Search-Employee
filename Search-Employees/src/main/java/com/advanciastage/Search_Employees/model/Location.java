package com.advanciastage.Search_Employees.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="LOCATIONS")
public class Location {
	
	@Id
	@Column(name="LOCATION_ID")
	private Long id;
	
	@Column(name="CITY")
	private String city;
	
	@ManyToOne
	@JoinColumn(name="COUNTRY_ID")
	private Countries countries;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Countries getCountries() {
		return countries;
	}

	public void setCountries(Countries countries) {
		this.countries = countries;
	}
	
	
}
