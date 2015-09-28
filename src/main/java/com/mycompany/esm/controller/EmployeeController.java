package com.mycompany.esm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mycompany.esm.model.Employee;
import com.mycompany.esm.model.Skill;
import com.mycompany.esm.service.EmployeeService;

@Controller
@RequestMapping("/employee")
@SessionAttributes("skills")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = { "/", "/listEmployees" })
	public String listEmployees(Map<String, Object> map) {
		System.out.println("Inside listEmployees");
		map.put("employee", new Employee());

		map.put("employeeList", employeeService.listEmployees());

		return "/employee/listEmployees";
	}

	@RequestMapping("/get/{employeeId}")
	public String getEmployee(@PathVariable Long employeeId,
			Map<String, Object> map) {
		Employee employee = employeeService.getEmployee(employeeId);
		map.put("employee", employee);

		return "/employee/employeeForm";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee,
			BindingResult result) {
		employeeService.saveEmployee(employee);

		return "redirect:listEmployees";
	}

	@RequestMapping("/delete/{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId") Long id) {
		System.out.println("deleteEmployee with id :"+id);
		employeeService.deleteEmployee(id);

		return "redirect:/employee/listEmployees";
	}
	
	@ModelAttribute("skills")
	public List<Skill> initializeSkills() {
		return employeeService.getAllSkills();
	}

}
