package com.capgemini.springboot.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.springboot.demo.model.Employee;

@Service
public class EmployeeService {

	private List<Employee> empList = new ArrayList<>();;

	{
		empList.add(new Employee(101, "Sajal", 50000));
		empList.add(new Employee(102, "Kabir", 30000));
		empList.add(new Employee(103, "Yash", 40000));
		empList.add(new Employee(104, "Adil", 60000));
		empList.add(new Employee(105, "Sparsh", 70000));
	}

	public Employee getEmpById(int employeeId) {
		System.out.println("Employee Service : get-by-id");
		for (Employee emp : empList)
			if (emp.getEmployeeId() == employeeId)
				return emp;
			else
				System.out.println("----------EMPLOYEE NOT FOUND----------");
		return null;
	}

	public Employee addEmp(int id, String firstName, double salary) {
		Employee newEmp = new Employee(id, firstName, salary);
		empList.add(newEmp);
		return newEmp;
	}

	public Employee updateEmp(int employeeId) {
		for (Employee emp : empList)
			if (emp.getEmployeeId() == employeeId)
				emp.setSalary(emp.getSalary() * 2);
			else
				System.out.println("----------EMPLOYEE NOT FOUND----------");
		return null;
	}

	public Employee deleteEmp(int employeeId) {
		for (Employee emp : empList)
			if (emp.getEmployeeId() == employeeId)
				empList.remove(emp);
			else
				System.out.println("----------EMPLOYEE NOT FOUND----------");
		return null;
	}
}
