package com.advanciastage.Search_Employees.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advanciastage.Search_Employees.Repository.LocationRepository;
import com.advanciastage.Search_Employees.model.Location;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LocationService {
	
	@Autowired
	LocationRepository repo;
	
	public List<Location> findAll() {
		return repo.findAll();
	}
	
	public Location find(Long id) {
		return repo.findById(id).orElse(null);
	}
	
}
