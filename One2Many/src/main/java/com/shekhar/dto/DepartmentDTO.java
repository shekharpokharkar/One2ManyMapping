/**
 * 
 */
package com.shekhar.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shekhar.entity.Department;
import com.shekhar.entity.Employee;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author shekhar
 */

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
	private Long departmentId;
	private String departmentName;
	private String departmentHOD;
	private Integer departmentStrength;
	private Integer departmentStaff;

	@JsonProperty("employee")
	private List<EmployeeDTO> employeeDTO;
}
