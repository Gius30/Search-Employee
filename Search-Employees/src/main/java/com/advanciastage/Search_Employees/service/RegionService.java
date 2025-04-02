package com.advanciastage.Search_Employees.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advanciastage.Search_Employees.Repository.RegionsRepository;
import com.advanciastage.Search_Employees.model.Regions;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegionService {

	@Autowired
	RegionsRepository repo;

	public List<Regions> findAll() {
		return repo.findAll();
	}

	public Regions find(Long id) {
		return repo.findById(id).orElse(null);
	}

}
