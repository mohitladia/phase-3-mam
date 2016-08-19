package com.flp.ems.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CAP_FLP_Role")
public class Role {
	
	@Id
	private int roleId;
	private String roleName;
	private String description;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,
			targetEntity=Employee.class,mappedBy="role")
	private List<Employee> employees;
	
	public Role()
	{}
	
	public Role(int roleId, String roleName, String description) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.description = description;
	}
	
	
	
	public Role(int roleId, String roleName, String description, List<Employee> employees) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.description = description;
		this.employees = employees;
	}

	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", description=" + description + ", employees="
				+ employees + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + roleId;
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
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
		Role other = (Role) obj;
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
		if (roleId != other.roleId)
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		return true;
	}
	
	
}
