package com.advanciastage.Search_Employees.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advanciastage.Search_Employees.Repository.EmployeeRepository;
import com.advanciastage.Search_Employees.model.Employees;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repo;
	
	public List<Employees> findAll() {
		return repo.findAll();
	}
	
	public Employees find(Long id) {
		return repo.findById(id).orElse(null);
	}

	public List<Employees> searchEmployees(Long id_dipartimento, Long id_location, String id_country,
			String nome_employee, Long id_region, Double max_salary, Double min_salary) {
		return repo.search(id_dipartimento, id_location, id_country, 
                nome_employee, id_region, max_salary, min_salary);
	}

	public void DeleteEmployeebyId(Long id) {
		repo.deleteById(id);
	}

	
	/*
	 * ricorda che se edit_emp non ha id allora verrà creata una nuova entità sennò verrà aggiornata 
	 * l'entità con l' id corrispondente
	 */
	
	public Optional<Employees> editEmployee(long id, String nome, BigDecimal salary) {
	        repo.updateEmployeeSalary(id,nome,salary);
	        return repo.findById(id);
	    
	}

	
	

	
}
