/**
 * 
 */
package com.shekhar.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shekhar.dto.EmployeeDTO;
import com.shekhar.entity.Employee;
import com.shekhar.repository.EmployeeRepository;
import com.shekhar.utils.EmployeeUtils;

/**
 * @author shekhar
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO employeeDTO) {
		Employee employee = repository.findById(employeeId)
				.orElseThrow(() -> new RuntimeException("Employee Not found"));

		BeanUtils.copyProperties(employeeDTO, employee);
		employee.setEmployeeId(employeeId);

		Employee employee1 = repository.save(employee);
		return EmployeeUtils.map(employee1);

	}

	@Override
	public EmployeeDTO getEmployeeById(Long employeeId) {

		Employee employee = repository.findById(employeeId)
				.orElseThrow(() -> new RuntimeException("Employee Not found"));

		return EmployeeUtils.map(employee);

	}

	@Override
	public List<EmployeeDTO> getAllEmployee() {
		return repository.findAll().stream().map(EmployeeUtils::map).toList();

	}

	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
		return EmployeeUtils.map(repository.save(EmployeeUtils.map(employeeDTO)));

	}

	@Override
	public EmployeeDTO partialUpdateEmployee(Long employeeId, Map<String, Object> employeeDTO) {

		Employee employee = repository.findById(employeeId)
				.orElseThrow(() -> new RuntimeException("Employee Not found"));

		return null;
	}

	@Override
	public EmployeeDTO deleteEmployee(Long employeeId) {
		Employee employee = repository.findById(employeeId)
				.orElseThrow(() -> new RuntimeException("Employee Not found"));

		repository.delete(employee);
		return EmployeeUtils.map(employee);

	}

}
