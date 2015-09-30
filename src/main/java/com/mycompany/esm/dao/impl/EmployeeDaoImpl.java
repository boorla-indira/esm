package com.mycompany.esm.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.esm.dao.EmployeeDao;
import com.mycompany.esm.model.Employee;
import com.mycompany.esm.model.Skill;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	public void saveEmployee(Employee employee) {
		System.out.println("EmployeeDaoImpl saveEmployee : employee name : "+employee.getName());
		getSession().merge(employee);

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Employee> listEmployees() {
		System.out.println(" getSessionFactory() : employee : : "+ getSessionFactory());
		return getSession().createCriteria(Employee.class).list();
	}

	public Employee getEmployee(Long id) {
		
		return (Employee)getSession().get(Employee.class, id);
	}
	
	public Session getSession(){
		Session session = null;
		try{
			session = getSessionFactory().getCurrentSession();
		} catch (HibernateException hibernateException){
			session = getSessionFactory().openSession();
		}
		
		
		return session;
	}

	public void deleteEmployee(Long id) {
		Employee employee = getEmployee(id);
		System.out.println("EmployeeDaoImpl deleteEmployee");
		if(employee != null){
			System.out.println("deleteEmployee employee id name "+employee.getId()+" -- "+employee.getName());
			getSession().delete(employee);
		}
	}

	public List<Skill> getAllSkills() {
		System.out.println("getAllSkills() getSessionFactory() : employee : : "+ getSessionFactory());
		return getSession().createCriteria(Skill.class).list();
	}

	public Skill getSkill(Long id) {
		// TODO Auto-generated method stub
		return (Skill)getSession().get(Skill.class, id);
	}

}
