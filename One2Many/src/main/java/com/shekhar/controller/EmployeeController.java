/**
 * 
 */
package com.shekhar.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shekhar.dto.EmployeeDTO;
import com.shekhar.service.EmployeeService;

/**
 * @author shekhar
 */

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/")
	public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
		EmployeeDTO employee = employeeService.saveEmployee(employeeDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
	}

	@GetMapping("/")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployee() {
		List<EmployeeDTO> employee = employeeService.getAllEmployee();
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}

	@GetMapping("/{employeeId}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("employeeId") Long EmployeeId) {
		EmployeeDTO employee = employeeService.getEmployeeById(EmployeeId);
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}

	@PutMapping("/{employeeId}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("employeeId") Long EmployeeId,
			@RequestBody EmployeeDTO employeeDTO) {
		EmployeeDTO employee = employeeService.updateEmployee(EmployeeId, employeeDTO);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(employee);
	}

	@PatchMapping("/{employeeId}")
	public ResponseEntity<EmployeeDTO> partialUpdateEmployee(@PathVariable("employeeId") Long EmployeeId,
			@RequestBody Map<String, Object> employeeDTO) {
		EmployeeDTO employee = employeeService.partialUpdateEmployee(EmployeeId, employeeDTO);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(employee);
	}

	@DeleteMapping("/{employeeId}")
	public ResponseEntity<EmployeeDTO> deleteEmployee(@PathVariable("employeeId") Long EmployeeId) {
		EmployeeDTO employee = employeeService.deleteEmployee(EmployeeId);
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}

}
