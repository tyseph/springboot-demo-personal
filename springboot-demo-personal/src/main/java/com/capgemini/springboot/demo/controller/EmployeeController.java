package com.capgemini.springboot.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springboot.demo.model.Employee;
import com.capgemini.springboot.demo.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EmployeeService service;

	@GetMapping("/get-employee-by-id/{eid}")
	public ResponseEntity<Employee> getEmployeeBtId(@PathVariable(name = "eid") int id) {
//		int id = 106;
		LOG.info("Employee Controller : get-by-id");
//		return service.getEmpById(id);
		Employee emp = service.getEmpById(id);
		HttpHeaders header = new HttpHeaders();
		header.add("message", "Employee" + id + " not found");
		ResponseEntity<Employee> response = new ResponseEntity<>(emp, header, HttpStatus.OK);
		return response;
	}

	@GetMapping("/get-all-employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
//		HttpHeaders header = new HttpHeaders().add("message", "Success");
		return new ResponseEntity<>(service.getAllEmp(), HttpStatus.OK);
//		return null;
	}

	@PostMapping("/add-employee")
	public ResponseEntity<List<Employee>> addEmployee(@RequestBody Employee employee) {
//		service.addEmp(, firstName, salary);
		LOG.info("----------EMPLOYEE ADDED----------");
		return new ResponseEntity<>(service.addEmp(employee), HttpStatus.OK);
	}

	@PostMapping("/update-employee/{eid}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(name = "eid") int id) {
//		int id = 103;
		LOG.info("----------EMPLOYEE SALARY UPDATED----------");
		return new ResponseEntity<>(service.updateEmp(id), HttpStatus.OK);
//		return null;
	}

	@DeleteMapping("/delete-employee/{eid}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(name = "eid") int id) {
//		int id = 104;
		System.out.println("----------EMPLOYEE DELETED----------");
		return new ResponseEntity<>(service.deleteEmp(id), HttpStatus.OK);

	}

}
