package com.advanciastage.Search_Employees.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.advanciastage.Search_Employees.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
}
