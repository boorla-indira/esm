package com.mycompany.esm.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
@SessionAttributes("skillsList")
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
		System.out.println("/save method ...");
		Set<Skill> skills = employee.getSkills();
		System.out.println("save - skills :"+skills);
		for (Iterator iterator = skills.iterator(); iterator.hasNext();) {
			Skill skill = (Skill) iterator.next();
			System.out.println("save - skills - employee skills: "+skill.getName()+" - "+skill.getId());
			
		}
		
		//System.out.println(employee.);
		employeeService.saveEmployee(employee);

		return "redirect:listEmployees";
	}

	@RequestMapping("/delete/{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId") Long id) {
		System.out.println("deleteEmployee with id :"+id);
		employeeService.deleteEmployee(id);

		return "redirect:/employee/listEmployees";
	}
	
	@ModelAttribute("skillsList")	
	public List<Skill> initializeSkills() {
		List skills = employeeService.getAllSkills();
		System.out.println("In initializeSkills() ");
		for (Iterator iterator = skills.iterator(); iterator.hasNext();) {
			Skill skill = (Skill) iterator.next();
			System.out.println("Skill "+skill.getName() +" - "+skill.getId());
			
		}
		return skills;
	}

	/*
	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception{
		System.out.println("In initBinder");
		binder.registerCustomEditor(Set.class, "skills", new CustomCollectionEditor(Set.class){
			@Override
			protected Object convertElement(Object element) {
				Long id = null;
				if(element instanceof String && !((String)element).equals("")){
					System.out.println("element instanceof String && !((String)element).equals()");
					try{
						System.out.println("try Element was "+ (String)element);
						id = Long.parseLong((String)element);
					}catch(NumberFormatException e){
						System.out.println("catch Element was "+ (String)element);
						e.printStackTrace();
					}
				}
				else if (element instanceof Long){
					System.out.println("element instanceof Long "+element);
					id = (Long)element;
				}
				
				if(id !=null){
					System.out.println("if id !=null");
					return employeeService.getSkill(id);
					
				}else{
					System.out.println("id== null else");
					return null;
				}
				//return id !=null ? employeeService.getSkill(id): null;

			}
		});
	}
	
	*/
}
