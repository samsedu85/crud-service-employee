/**
 * 
 */
package com.invex.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.invex.dto.EmployeeDTO;
import com.invex.exception.GlobalExceptionHandler;
import com.invex.model.mapper.EmployeeMapper;
import com.invex.model.service.EmployeeServiceImpl;

/**
 * @author EduSam
 *
 */
//@ExtendWith(MockitoExtension.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

	@MockBean
	private MockMvc mockMvc;

	@Mock
	private EmployeeServiceImpl service;

	@Mock
	private EmployeeMapper mapper;

	@InjectMocks
	private EmployeeController employeeController;

	EmployeeDTO employeeDTO;
	List<EmployeeDTO> listEmployee = null;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(employeeController).setControllerAdvice(new GlobalExceptionHandler())
				.build();
		employeeDTO = new EmployeeDTO();
		employeeDTO.setAge(40);
		employeeDTO.setDateOfBirth(LocalDate.now().of(2005, Month.APRIL, 12));
		employeeDTO.setFirstName("Manuel");
		employeeDTO.setId(1L);
		employeeDTO.setMaternalSurname("Maternal");
		employeeDTO.setPaternalSurname("Paternal");
		employeeDTO.setPosition("Java");
		employeeDTO.setSecondName("Manuel2");
		employeeDTO.setSex("M");
		employeeDTO.setStatus(Boolean.TRUE);

		listEmployee = new ArrayList<>();
		listEmployee.add(employeeDTO);
	}

	@Test
	void testEmployeeUpdateSuccessful() throws Exception {

		when(service.findById(1L)).thenReturn(employeeDTO);
		when(mapper.updateCurrentEmployee(employeeDTO, new EmployeeDTO())).thenReturn(listEmployee);
		when(service.save(listEmployee)).thenReturn(listEmployee);
		MockHttpServletResponse response = mockMvc
				.perform(get("http://localhost/api/v1/employees/1").accept(MediaType.APPLICATION_JSON)).andReturn()
				.getResponse();

		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
	}

}
