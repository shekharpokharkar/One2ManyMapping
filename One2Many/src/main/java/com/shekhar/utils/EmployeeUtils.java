/**
 * 
 */
package com.shekhar.utils;

import org.springframework.beans.BeanUtils;

import com.shekhar.dto.DepartmentDTO;
import com.shekhar.dto.EmployeeDTO;
import com.shekhar.entity.Department;
import com.shekhar.entity.Employee;

/**
 * @author shekhar
 */
public interface EmployeeUtils {

	public static Employee map(EmployeeDTO employeedto) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeedto, employee);
		if (employeedto.getDepartmentdto() != null) {
			DepartmentDTO departmentdto = employeedto.getDepartmentdto();
			Department department = new Department();
			BeanUtils.copyProperties(departmentdto, department);
			employee.setDepartment(department);
		}
		return employee;

	}

	public static EmployeeDTO map(Employee employee) {
		EmployeeDTO dto = new EmployeeDTO();
		BeanUtils.copyProperties(employee, dto);
		if (employee.getDepartment() != null) {
			Department department = employee.getDepartment();
			DepartmentDTO departmentDTO = new DepartmentDTO();
			BeanUtils.copyProperties(department, departmentDTO);
			dto.setDepartmentdto(departmentDTO);
		}
		return dto;

	}
}
