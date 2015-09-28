package com.mycompany.esm.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name="SKILL")
public class Skill {
	@Id
	@Column(name="SKILL_ID")
	@GeneratedValue
	private Long skillId;
	
	@Column(name="SKILLNAME")
	private String name;
	
	@ManyToMany (mappedBy="skills")
	private Set<Employee> employees = new HashSet<Employee>();
	
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	public Long getSkillId() {
		return skillId;
	}
	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
