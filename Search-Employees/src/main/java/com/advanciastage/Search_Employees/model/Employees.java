package com.advanciastage.Search_Employees.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLOYEES")
public class Employees {
	@Id
	@Column(name = "EMPLOYEE_ID")
	//questo mi serve in caso di creazione di un nuovo dipendente , poichè vado a prendere la sequenza per incrementare l'id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
	//@SequenceGenerator(name = "employee_seq", sequenceName = "EMPLOYEES_SEQ", allocationSize = 1)
	private Long id;
	
	@Column(name = " FIRST_NAME")
	private String first_name;
	
	@Column(name = "SALARY")
    private BigDecimal salary;
	
	 @ManyToOne 
     @JoinColumn(name="DEPARTMENT_ID")
     private Department department;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	 
	 

	

}
