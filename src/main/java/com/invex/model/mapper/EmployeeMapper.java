/**
 * 
 */
package com.invex.model.mapper;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.invex.dto.EmployeeDTO;

/**
 * @author EduSam
 *
 */
@Component
public class EmployeeMapper {

	public List<EmployeeDTO> updateCurrentEmployee(EmployeeDTO findedEmployee, EmployeeDTO newEmployee) {
		BeanUtils.copyProperties(newEmployee, findedEmployee);
		return Arrays.asList(findedEmployee);
	}

}
