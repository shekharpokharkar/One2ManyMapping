/**
 * 
 */
package com.shekhar.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.shekhar.dto.DepartmentDTO;
import com.shekhar.dto.EmployeeDTO;
import com.shekhar.entity.Department;
import com.shekhar.entity.Employee;

/**
 * @author shekhar
 */
public interface DepartmentUtils {

	public static Department map(DepartmentDTO departmentDTO) {
		Department department = new Department();
		BeanUtils.copyProperties(departmentDTO, department);
		if (departmentDTO.getEmployeeDTO() != null) {

			List<EmployeeDTO> empDTOList = departmentDTO.getEmployeeDTO();
			List<Employee> emplist = new ArrayList<>();
			for (EmployeeDTO dto : empDTOList) {
				Employee emp = new Employee();
				BeanUtils.copyProperties(dto, emp);
				emp.setDepartment(department);
				emplist.add(emp);
			}

			department.setEmployee(emplist);
		}
		return department;

	}

	public static DepartmentDTO map(Department department) {

		DepartmentDTO dto = new DepartmentDTO();
		BeanUtils.copyProperties(department, dto);
		if (department.getEmployee() != null) {
			List<Employee> employee = department.getEmployee();
			List<EmployeeDTO> empDTOList = new ArrayList<>();

			for (Employee emp : employee) {
				EmployeeDTO empDTO = new EmployeeDTO();
				BeanUtils.copyProperties(emp, empDTO);
				empDTO.setDepartmentdto(dto);
				empDTOList.add(empDTO);

			}
			dto.setEmployeeDTO(empDTOList);
		}

		return dto;

	}
}
