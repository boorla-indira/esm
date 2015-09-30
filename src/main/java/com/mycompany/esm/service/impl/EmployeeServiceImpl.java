package com.mycompany.esm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.esm.dao.EmployeeDao;
import com.mycompany.esm.model.Employee;
import com.mycompany.esm.model.Skill;
import com.mycompany.esm.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Transactional
	public void saveEmployee(Employee employee) {
		System.out.println("EmployeeServiceImpl - start");
		employeeDao.saveEmployee(employee);
		System.out.println("EmployeeServiceImpl - End");

	}

	@Transactional(readOnly = true)
	public List<Employee> listEmployees() {
		System.out.println("EmployeeServiceImpl - listEmployees");
		return employeeDao.listEmployees();
	}

	@Transactional(readOnly = true)
	public Employee getEmployee(Long id) {
		System.out.println("EmployeeServiceImpl --getEmployee : " + id);
		return employeeDao.getEmployee(id);
	}

	@Transactional
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		employeeDao.deleteEmployee(id);
	}
	
	@Transactional(readOnly = true)
	public List<Skill> getAllSkills() {
		// TODO Auto-generated method stub
		return employeeDao.getAllSkills();
	}

	@Transactional(readOnly = true)
	public Skill getSkill(Long id) {
		System.out.println("EmployeeServiceImpl - getSkill(Long id)");
		return employeeDao.getSkill(id);
	}
	
	@Transactional(readOnly = true)
	public List<Employee> getEmployeesBySkills(Long skillId) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeesBySkills(skillId);
	}

	

}
