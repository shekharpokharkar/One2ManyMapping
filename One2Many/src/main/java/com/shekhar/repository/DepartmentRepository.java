/**
 * 
 */
package com.shekhar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shekhar.entity.Department;
import com.shekhar.entity.Employee;

/**
 * @author shekhar
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
