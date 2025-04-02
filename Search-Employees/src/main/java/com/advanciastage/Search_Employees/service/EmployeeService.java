package com.advanciastage.Search_Employees.service;

import java.util.List;

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
	
}
