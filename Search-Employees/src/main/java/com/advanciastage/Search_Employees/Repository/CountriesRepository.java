package com.advanciastage.Search_Employees.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.advanciastage.Search_Employees.model.Countries;

public interface CountriesRepository extends JpaRepository<Countries, Long>{
	
}
