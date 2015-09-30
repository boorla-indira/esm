package com.mycompany.esm.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	@Id
	@Column(name="EMPLOYEE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String department;
	
	/*
	private List<Skill> skillsList = new ArrayList<Skill>();

	public List<Skill> getSkillsList() {
		return skillsList;
	}

	public void setSkillsList(List<Skill> skillsList) {
		this.skillsList = skillsList;
		skills = new HashSet<Skill>(skillsList);
	}
 */
	@ManyToMany(fetch= FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinTable(name = "EMPLOYEE_SKILL",
				joinColumns = { @JoinColumn(name = "EMPLOYEE_ID", nullable = false, updatable = false), }, 
				inverseJoinColumns = { @JoinColumn(name = "SKILL_ID", nullable = false, updatable = false) })
	private Set<Skill> skills = new HashSet<Skill>();

	public Employee() {
		
    }
 
	public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

	public Long getId() {
		return id;
	}

	public Set<Skill> getSkills() {
		//skills.add(new Skill())
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
//		for (Iterator iterator = skills.iterator(); iterator.hasNext();) {
//			
//			Skill skill = (Skill) iterator.next();
//			System.out.println("Employee setSkills skill "+skill.getId());
//			this.skills.add(skill);
//		}
		this.skills = skills;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Employee))
            return false;
        Employee other = (Employee) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name +"]";
    }


}
