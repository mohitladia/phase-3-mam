package com.flp.ems.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CAP_FLP_Project")
public class Project {
	
	@Id
	private int projectId;
	private String projectName;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="departemtnId_Fk")
	private Department department;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,
			targetEntity=Employee.class,mappedBy="project")
	private List<Employee> employees;
	
	public Project(){}
	
	public Project(int projectId, String projectName, String description,
			Department department) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.description = description;
		this.department = department;
	}
	
	
	
	
	public Project(int projectId, String projectName, String description, Department department,
			List<Employee> employees) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.description = description;
		this.department = department;
		this.employees = employees;
	}

	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + projectId;
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (projectId != other.projectId)
			return false;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", description=" + description
				+ ", department=" + department + ", employees=" + employees + "]";
	}
	
	
	

}
