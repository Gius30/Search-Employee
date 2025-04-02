package com.advanciastage.Search_Employees.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advanciastage.Search_Employees.Repository.DepartmentRepository;
import com.advanciastage.Search_Employees.model.Department;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DepartmentService {
	
	@Autowired
	DepartmentRepository repo;
	
	public List<Department> findAll() {
		return repo.findAll();
	}
	
	public Department find(Long id) {
		return repo.findById(id).orElse(null);
	}
	
}
