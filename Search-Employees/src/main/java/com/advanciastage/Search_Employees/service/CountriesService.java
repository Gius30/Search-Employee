package com.advanciastage.Search_Employees.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advanciastage.Search_Employees.Repository.CountriesRepository;
import com.advanciastage.Search_Employees.model.Countries;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CountriesService {
	
	@Autowired
	CountriesRepository repo;
	
	public List<Countries> findAll() {
		return repo.findAll();
	}
	
	public Countries find(Long id) {
		return repo.findById(id).orElse(null);
	}
	
}
