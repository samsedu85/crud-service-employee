/**
 * 
 */
package com.invex.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author EduSam
 *
 */
@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -29450091370494445L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_employee")
	private Long idEmployee;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "second_name")
	private String secondName;

	@Column(name = "paternal_surname")
	private String paternalSurname;

	@Column(name = "maternal_surname")
	private String maternalSurname;

	private Integer age;

	private String sex;

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	private String position;

	@Column(name = "join_date")
	private LocalDateTime joinDate;

	private Boolean status;

}
