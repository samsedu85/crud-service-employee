/**
 * 
 */
package com.invex.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invex.model.entity.Employee;

/**
 * @author EduSam
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Optional<List<Employee>> findByFirstName(String name);

}
