package com.flp.ems.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.flp.ems.domain.Employee;
import com.flp.ems.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/empForm")
	public String showEmployeeForm(ModelMap map){
		map.put("employee",new Employee());
		map.put("departments", employeeService.getAllDepartments());
		map.put("projects", employeeService.getAllProjects());
		map.put("roles", employeeService.getAllRoles());
		map.put("employees", employeeService.getAllEmployees());
		return "empPage";
	}
	@RequestMapping(value="/empSave",method=RequestMethod.POST)
	public String saveEmployee(@Valid @ModelAttribute("employee")Employee employee,
			BindingResult results,ModelMap map){
		map.put("departments", employeeService.getAllDepartments());
		map.put("projects", employeeService.getAllProjects());
		map.put("roles", employeeService.getAllRoles());
		map.put("employees", employeeService.getAllEmployees());
		if(results.hasErrors()){
			System.out.println(results.getAllErrors());
			return "empPage";
		}else{
			//if(employee.getEmpId() == -1){
				employeeService.saveEmployee(employee);
			//	}
			/*else{
				employeeService.updateEmployee(employee);
				}*/
			return "redirect:empForm";
		}
	}
	
	
	@RequestMapping("/deleteEmployee/{empId}")
	public String deleteEmployee(@PathVariable("empId") Integer employeeId){
		employeeService.deleteEmployee(employeeId);
		
		return "redirect:empForm";
	}
	@RequestMapping("/updateEmployee")
	public String showEmployeeForm(ModelMap map,@RequestParam(value="id",required=false) String employeeid){
		int id;
		if(employeeid!=null)
			id=Integer.parseInt(employeeid);
		else
			id=-1;
		if(id!=-1){
		Employee emp = employeeService.findById(id);
		System.out.println("Employee_id inside show EmployeeForm:"+emp.getEmpId());
		map.put("emp",emp);
	}
		map.put("departments", employeeService.getAllDepartments());
		map.put("projects", employeeService.getAllProjects());
		map.put("roles", employeeService.getAllRoles());
		map.put("employees", employeeService.getAllEmployees());
		return "employee";
	}
}
