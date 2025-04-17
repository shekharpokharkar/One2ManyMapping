/**
 * 
 */
package com.shekhar.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
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
public class EmployeeDTO {

	private Long employeeId;
	private String employeeNane;
	@JsonProperty("DOB")
	@JsonFormat(pattern = "dd-MM-yyyy")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate employeeDateOfBirth;
	private BigDecimal employeeSalary;
	@JsonProperty("MariatalStatus")
	private Boolean isMarried;
	private Character employeeGender;

	@Column(name = "departmet")
	private DepartmentDTO departmentdto;
}
