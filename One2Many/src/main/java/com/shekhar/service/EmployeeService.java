/**
 * 
 */
package com.shekhar.service;

import java.util.List;
import java.util.Map;

import com.shekhar.dto.EmployeeDTO;

/**
 * @author shekhar
 */
public interface EmployeeService {

	/**
	 * @param employeeId
	 * @param employeeDTO
	 * @return
	 */
	EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO employeeDTO);

	/**
	 * @param employeeId
	 * @return
	 */
	EmployeeDTO getEmployeeById(Long employeeId);

	/**
	 * @return
	 */
	List<EmployeeDTO> getAllEmployee();

	

	/**
	 * @param employeeDTO
	 * @return
	 */
	EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

	/**
	 * @param employeeId
	 * @param employeeDTO
	 * @return
	 */
	EmployeeDTO partialUpdateEmployee(Long employeeId, Map<String, Object> employeeDTO);

	/**
	 * @param employeeId
	 * @return
	 */
	EmployeeDTO deleteEmployee(Long employeeId);

}
