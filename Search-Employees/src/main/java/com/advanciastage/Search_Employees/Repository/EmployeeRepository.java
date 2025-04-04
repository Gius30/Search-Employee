package com.advanciastage.Search_Employees.Repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.advanciastage.Search_Employees.model.Employees;



public interface EmployeeRepository extends JpaRepository<Employees, Long> {

	@Query("select e from Employees e " + "join e.department d " + "join d.location l " + "join l.countries c "
			+ "join c.regions r " + "where " + "(:id_dipartimento is null or d.id = :id_dipartimento) and "
			+ "(:id_location is null or l.id = :id_location) and " + "(:id_country is null or c.id = :id_country) and "
			+ "(:nome_employee is null or LOWER(e.first_name) LIKE LOWER( :nome_employee)) and "
			+ "(:id_region is null or r.id = :id_region) and " + "(:max_salary is null or e.salary <= :max_salary) and "
			+ "(:min_salary is null or e.salary >= :min_salary)")
	List<Employees> search(Long id_dipartimento, Long id_location, String id_country, String nome_employee,
			Long id_region, Double max_salary, Double min_salary);
	
	@Modifying
    @Transactional
    @Query("update Employees e set e.salary = :newSalary, e.first_name = :nome " + 
           "where e.id = :employeeId")
    void updateEmployeeSalary(Long employeeId, String nome, BigDecimal newSalary);
}
