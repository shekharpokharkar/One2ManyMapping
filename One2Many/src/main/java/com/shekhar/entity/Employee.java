/**
 * 
 */
package com.shekhar.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author shekhar
 */
@Entity
@Builder
@Table(name = "Employees")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	private String employeeNane;
	@Column(name = "DOB")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate employeeDateOfBirth;
	private BigDecimal employeeSalary;
	@Column(name = "MariatalStatus")
	private Boolean isMarried;
	private Character employeeGender;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "DepartmentId")
	private Department department;

}
