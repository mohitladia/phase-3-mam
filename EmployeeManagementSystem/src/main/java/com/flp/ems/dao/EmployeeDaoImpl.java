package com.flp.ems.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveEmployee(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
		
	}

	@Override
	public List<Department> getAllDepartments() {
		
		return sessionFactory.getCurrentSession().createQuery("from Department").list();
	}

	@Override
	public List<Project> getAllProjects() {
		
		return sessionFactory.getCurrentSession().createQuery("from Project").list();
	}

	@Override
	public List<Role> getAllRoles() {
		return sessionFactory.getCurrentSession().createQuery("from Role").list();
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	@Override
	public Employee findById(int id) {
		Employee emp=(Employee)sessionFactory.getCurrentSession().get(Employee.class, id);
	    return emp; 
	}

	@Override
	public void updateEmployee(Employee emp) {
		sessionFactory.getCurrentSession().update(emp);
		
	}

	@Override
	public void deleteEmployee(int employeeId) {
		Employee emp=(Employee)sessionFactory.getCurrentSession().get(Employee.class, employeeId);
		if(emp!=null)
			sessionFactory.getCurrentSession().delete(emp);
		
	}

}
