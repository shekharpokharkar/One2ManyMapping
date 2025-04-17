/**
 * 
 */
package com.shekhar.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity
@Builder
@Table(name = "Departments")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long departmentId;
	private String departmentName;
	private String departmentHOD;
	private Integer departmentStrength;
	private Integer departmentStaff;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE, CascadeType.MERGE,
			CascadeType.PERSIST }, mappedBy = "", orphanRemoval = true)
	private List<Employee> employee;

}
