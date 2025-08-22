/**
 * 
 */
package com.invex.model.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.invex.commons.exception.NotFoundInvexException;
import com.invex.model.repository.EmployeeRepository;

/**
 * @author EduSam
 *
 */
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {

	@Mock
	private EmployeeRepository repository;

	@InjectMocks
	private EmployeeServiceImpl service;

	@Test
	void testGetEmployeeByFirstName_exceptionNotFound() {

		when(repository.findByFirstName("Hugo")).thenReturn(Optional.of(new ArrayList<>()));
		try {
			service.employeeByName("Hugo");

		} catch (NotFoundInvexException error) {
			assertEquals(404, error.getErrorCode());
		}

	}

}
