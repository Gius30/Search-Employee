package com.advanciastage.Search_Employees.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.advanciastage.Search_Employees.model.Employees;

public interface EmployeeRepository extends JpaRepository<Employees, Long>{
	//qua dentro metto la query della ricerca
}
