package com.flp.ems.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="CAP_FLP_Employee")
public class Employee {
	
	@Id
	@GeneratedValue
	private int empId;
	@NotEmpty(message="* Please Enter FirstName.")
	private String eName;
	@NotEmpty(message="* Please Enter kinId.")
	private String kinId;
	@Email(message="* Please Enter emailId.")
	private String emailId;
	@NotEmpty(message="* Please Enter phoneno.")
	private String phoneno;
	@NotEmpty(message="* Please Enter address.")
	private String address;
	
	private Date empdob;
	private Date empdoj;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="departId_fk")
	private Department department;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="projectId_fk")
	private Project project;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="roleId_fk")
	private Role role;
	
	
	public Employee(){}
	
	public Employee(String eName, String kinId, String emailId, String phoneno,
			String address, Date empdob, Date empdoj, Department department,
			Project project, Role role) {
		super();
		this.eName = eName;
		this.kinId = kinId;
		this.emailId = emailId;
		this.phoneno = phoneno;
		this.address = address;
		this.empdob = empdob;
		this.empdoj = empdoj;
		this.department = department;
		this.project = project;
		this.role = role;
	}
	
	
	
	
	public Employee(int empId, String eName, String kinId, String emailId, String phoneno, String address, Date empdob,
			Date empdoj, Department department, Project project, Role role) {
		super();
		this.empId = empId;
		this.eName = eName;
		this.kinId = kinId;
		this.emailId = emailId;
		this.phoneno = phoneno;
		this.address = address;
		this.empdob = empdob;
		this.empdoj = empdoj;
		this.department = department;
		this.project = project;
		this.role = role;
	}

	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getKinId() {
		return kinId;
	}
	public void setKinId(String kinId) {
		this.kinId = kinId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public Date getEmpdob(){
		return empdob;
	}
	
	/*public String getEmpdob() {
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MMM-yyyy");
		return dateFormat.format(empdob);
	}*/
	
	
	
	public void setEmpdob(Date empdob) {
		this.empdob = empdob;
	}
	public Date getEmpdoj() {
		return empdoj;
	}
	public void setEmpdoj(Date empdoj) {
		this.empdoj = empdoj;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", eName=" + eName + ", kinId=" + kinId + ", emailId=" + emailId
				+ ", phoneno=" + phoneno + ", address=" + address + ", empdob=" + empdob + ", empdoj=" + empdoj
				+ ", department=" + department + ", project=" + project + ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((eName == null) ? 0 : eName.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + empId;
		result = prime * result + ((empdob == null) ? 0 : empdob.hashCode());
		result = prime * result + ((empdoj == null) ? 0 : empdoj.hashCode());
		result = prime * result + ((kinId == null) ? 0 : kinId.hashCode());
		result = prime * result + ((phoneno == null) ? 0 : phoneno.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		Employee other = (Employee) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (eName == null) {
			if (other.eName != null)
				return false;
		} else if (!eName.equals(other.eName))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (empId != other.empId)
			return false;
		if (empdob == null) {
			if (other.empdob != null)
				return false;
		} else if (!empdob.equals(other.empdob))
			return false;
		if (empdoj == null) {
			if (other.empdoj != null)
				return false;
		} else if (!empdoj.equals(other.empdoj))
			return false;
		if (kinId == null) {
			if (other.kinId != null)
				return false;
		} else if (!kinId.equals(other.kinId))
			return false;
		if (phoneno == null) {
			if (other.phoneno != null)
				return false;
		} else if (!phoneno.equals(other.phoneno))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

}
