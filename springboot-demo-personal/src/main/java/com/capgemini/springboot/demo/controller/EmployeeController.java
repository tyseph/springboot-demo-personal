package com.capgemini.springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springboot.demo.model.Employee;
import com.capgemini.springboot.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/get-employee-by-id")
	public Employee getEmployeeBtId() {
		int id = 106;
		System.out.println("Employee Controller : get-by-id");
		return service.getEmpById(id);
	}

	@GetMapping("/get-all-employees")
	public List<Employee> getAllEmployees() {
		return null;
	}

	@GetMapping("/add-employee")
	public Employee addEmployee() {
		int id = 106;
		String firstName = "Shyam";
		double salary = 1000000;
		service.addEmp(id, firstName, salary);
		System.out.println("----------EMPLOYEE ADDED----------");
		return null;
	}

	@GetMapping("/update-employee")
	public Employee updateEmployee() {
		int id = 103;
		service.updateEmp(id);
		System.out.println("----------EMPLOYEE SALARY UPDATED----------");
		return null;
	}

	@GetMapping("/update-employee")
	public Employee deleteEmployee() {
		int id = 104;
		service.deleteEmp(id);
		System.out.println("----------EMPLOYEE DELETED----------");
		return null;
	}

}
