package com.capgemini.springboot.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.capgemini.springboot.demo.model.Employee;

@Service
public class EmployeeService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	private List<Employee> empList;

	{
		empList = new ArrayList<>();
		empList.add(new Employee(101, "Sajal", 50000));
		empList.add(new Employee(102, "Kabir", 30000));
		empList.add(new Employee(103, "Yash", 40000));
		empList.add(new Employee(104, "Adil", 60000));
		empList.add(new Employee(105, "Sparsh", 70000));
	}

	public Employee getEmpById(int employeeId) {
		LOG.info("Employee Service : get-by-id");
		Employee emp = empList.stream().filter(e -> employeeId == e.getEmployeeId()).findAny().orElse(null);

//		for (Employee emp : empList)
//			if (emp.getEmployeeId() == employeeId)
//				return emp;
//			else
//				System.out.println("----------EMPLOYEE NOT FOUND----------");

		return emp;
	}

	public List<Employee> getAllEmp() {
		return empList;
	}

	public List<Employee> addEmp(Employee employee) {
//		Employee newEmp = new Employee(id, firstName, salary);
		empList.add(employee);
		return empList;
	}

	public Employee updateEmp(int employeeId) {
		empList.forEach(e -> {
			if (e.getEmployeeId() == employeeId)
				e.setSalary(e.getSalary() * 2);
			else
				LOG.info("----------EMPLOYEE NOT FOUND----------");

		});
		return null;
	}

	public Employee deleteEmp(int employeeId) {
		Employee emp = this.getEmpById(employeeId);
		empList.remove(emp);
		return emp;
	}
}
