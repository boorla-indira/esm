package com.mycompany.esm.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name="SKILL")
public class Skill implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SKILL_ID")
	@GeneratedValue
	private Long id;
	
	@Column(name="SKILLNAME")
	private String name;
	
	//@ManyToMany (fetch = FetchType.LAZY, mappedBy="skills")
	@ManyToMany (mappedBy="skills")
	private Set<Employee> employees = new HashSet<Employee>();
	
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	public Long getId() {
		return id;
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
	
	public Skill () {
             
    }
	public Skill (String name, Set<Employee> employees) {
        this.name = name; 
        this.employees = employees;
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
        if (!(obj instanceof Skill))
            return false;
        Skill other = (Skill) obj;
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
        return "Skill [id=" + id + ", name=" + name + "]";
    }

	
}
