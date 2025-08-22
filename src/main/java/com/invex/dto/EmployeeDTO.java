/**
 * 
 */
package com.invex.dto;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * @author EduSam
 *
 */
@Getter
@Setter
public class EmployeeDTO {

	@JsonIgnore
	private Long id;

	@Max(value = 50)
	@Min(value = 1)
	private String firstName;

	@Max(value = 50)
	private String secondName;

	@Max(value = 50)
	@Min(value = 1)
	private String paternalSurname;

	@Max(value = 50)
	@Min(value = 1)
	private String maternalSurname;

	@Max(value = 60)
	@Min(value = 18)
	private Integer age;

	@Max(value = 1)
	@Min(value = 1)
	private String sex;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateOfBirth;

	@Max(value = 50)
	@Min(value = 1)
	private String position;

	
	private Boolean status;

	/*
	 * public String getDateOfBirth() { return
	 * dateOfBirth.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")); }
	 */

}
