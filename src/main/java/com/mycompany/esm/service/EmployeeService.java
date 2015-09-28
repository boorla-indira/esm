package com.mycompany.esm.service;

import java.util.List;

import com.mycompany.esm.model.Employee;

public interface EmployeeService {

	public void saveEmployee(Employee employee);
	
	public List<Employee> listEmployees();
	public Employee getEmployee(Long id);
	
	public void deleteEmployee(Long id);
	
}
