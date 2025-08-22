/**
 * 
 */
package com.invex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.invex.commons.controller.GenericController;
import com.invex.dto.EmployeeDTO;
import com.invex.model.mapper.EmployeeMapper;
import com.invex.model.service.IEmployeeService;
import com.invex.response.DataResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * @author EduSam
 *
 */
@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController extends GenericController<EmployeeDTO, IEmployeeService> {

	@Autowired
	private EmployeeMapper mapper;

	/**
	 * @param employeeDTO
	 * @param id
	 * @return ResponseEntity
	 */
	@Operation(summary = "Update all or some of an employee's fields")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful update"),
			@ApiResponse(responseCode = "404", description = "Employee not found"),
			@ApiResponse(responseCode = "500", description = "Server error") })
	@PutMapping(path = "/{id}", consumes = "application/json")
	public ResponseEntity<?> employeeUpdate(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long id) {
		EmployeeDTO findedEmployee = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK)
				.body(service.save(mapper.updateCurrentEmployee(findedEmployee, employeeDTO)));
	}

	/**
	 * @param name
	 * @return DataResponse
	 */
	@Operation(summary = "Search employees by name")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful"),
			@ApiResponse(responseCode = "404", description = "Employee not found"),
			@ApiResponse(responseCode = "500", description = "Server error") })
	@GetMapping(path = "/search", produces = "application/json")
	public DataResponse<List<EmployeeDTO>> getEmployeeByName(
			@RequestParam(name = "name", required = true) String name) {
		List<EmployeeDTO> listEmployee = null;
		if (name != null && !name.isBlank()) {
			listEmployee = service.employeeByName(name);
		}
		return new DataResponse<List<EmployeeDTO>>(Boolean.TRUE, "", 200, listEmployee);
	}

}
