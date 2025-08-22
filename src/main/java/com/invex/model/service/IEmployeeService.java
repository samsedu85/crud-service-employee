/**
 * 
 */
package com.invex.model.service;

import java.util.List;

import com.invex.commons.service.IGenericService;
import com.invex.dto.EmployeeDTO;

/**
 * @author EduSam
 *
 */
public interface IEmployeeService extends IGenericService<EmployeeDTO> {

	/**
	 * @param name
	 * @return
	 */
	public List<EmployeeDTO> employeeByName(String name);

}
