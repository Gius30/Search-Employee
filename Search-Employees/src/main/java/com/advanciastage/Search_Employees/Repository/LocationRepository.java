package com.advanciastage.Search_Employees.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.advanciastage.Search_Employees.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long>{
	
}
