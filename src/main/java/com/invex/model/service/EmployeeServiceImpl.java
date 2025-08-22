/**
 * 
 */
package com.invex.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.invex.commons.exception.NotFoundInvexException;
import com.invex.commons.service.GenericServiceImpl;
import com.invex.dto.EmployeeDTO;
import com.invex.model.entity.Employee;
import com.invex.model.repository.EmployeeRepository;

/**
 * @author EduSam
 *
 */
@Service
public class EmployeeServiceImpl extends GenericServiceImpl<Employee, EmployeeDTO, EmployeeRepository>
		implements IEmployeeService {

	/**
	 * Metodo que regresa una lista de empleados que coincida con el nombre a buscar
	 * @param name
	 * @return List<EmployeeDTO>
	 */
	@Override
	public List<EmployeeDTO> employeeByName(String name) {

		List<EmployeeDTO> listEmployeeDto = new ArrayList<>();

		List<Employee> listEmployee = repository.findByFirstName(name)
				.orElseThrow(() -> new NotFoundInvexException("No record found", 404));

		if (listEmployee.isEmpty())
			throw new NotFoundInvexException("No record found", 404);

		listEmployee.forEach(employee -> {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			BeanUtils.copyProperties(employee, employeeDTO);
			listEmployeeDto.add(employeeDTO);
		});

		return listEmployeeDto;
	}

}
