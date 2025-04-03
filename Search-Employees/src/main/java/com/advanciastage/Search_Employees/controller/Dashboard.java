package com.advanciastage.Search_Employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.advanciastage.Search_Employees.model.Countries;
import com.advanciastage.Search_Employees.model.Department;
import com.advanciastage.Search_Employees.model.Employees;
import com.advanciastage.Search_Employees.model.Location;
import com.advanciastage.Search_Employees.model.Regions;
import com.advanciastage.Search_Employees.service.CountriesService;
import com.advanciastage.Search_Employees.service.DepartmentService;
import com.advanciastage.Search_Employees.service.EmployeeService;
import com.advanciastage.Search_Employees.service.LocationService;
import com.advanciastage.Search_Employees.service.RegionService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class Dashboard {
	@Autowired
	private EmployeeService empServ;

	@Autowired
	private CountriesService counServ;

	@Autowired
	private DepartmentService depServ;

	@Autowired
	private LocationService locServ;

	@Autowired
	private RegionService regServ;

	@GetMapping("/countries")
	public List<Countries> findAllCoun() {
		return counServ.findAll();
	}

	@GetMapping("/regions")
	public List<Regions> findAllReg() {
		return regServ.findAll();
	}

	@GetMapping("/employees")
	public List<Employees> findAllEmp() {
		return empServ.findAll();
	}

	@GetMapping("/departments")
	public List<Department> findAllDep() {
		return depServ.findAll();
	}

	@GetMapping("/locations")
	public List<Location> findAllLoc() {
		return locServ.findAll();
	}
	
	@GetMapping("/search")
	public List<Employees> EmpSearch(
	        @RequestParam(required = false) Long id_dipartimento,
	        @RequestParam(required = false) Long id_location,
	        @RequestParam(required = false) String id_country,  // Cambio da Long a String
	        @RequestParam(required = false) String nome_employee,
	        @RequestParam(required = false) Long id_region,
	        @RequestParam(required = false) Double max_salary,
	        @RequestParam(required = false) Double min_salary) {
	    return empServ.searchEmployees(id_dipartimento, id_location, id_country, 
	                                   nome_employee, id_region, max_salary, min_salary);
	}
	
	@DeleteMapping("/employee/{id}")
	public List<Employees> DeleteEmployee(@PathVariable Long id){
		empServ.DeleteEmployeebyId(id);
		return empServ.findAll();
	}
	
	@GetMapping("/employee/{id}")
	public Employees DetailEmployee(@PathVariable Long id) {
		return empServ.find(id);
	}
	

}
