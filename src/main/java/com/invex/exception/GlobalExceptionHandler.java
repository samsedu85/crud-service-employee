/**
 * 
 */
package com.invex.exception;

import static com.invex.utils.EmployeeConstans.ERROR_INTERNO;
import static com.invex.utils.EmployeeConstans.ERROR_PROCESO;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.invex.commons.exception.NotFoundInvexException;
import com.invex.response.DataResponse;

import lombok.extern.log4j.Log4j2;;

/**
 * @author EduSam
 *
 */
@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Global null pointer exception handler.
	 *
	 * @param nullPointer null pointer
	 * @return data response
	 */
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NullPointerException.class)
	@ResponseBody
	public DataResponse<Object> globalNullPointerExceptionHandler(NullPointerException nullPointer) {
		log.error("NullPointerExceptionHandler: " + nullPointer.fillInStackTrace());
		return new DataResponse<>(Boolean.FALSE, ERROR_PROCESO, null);
	}

	/**
	 * Global internal server error.
	 *
	 * @param serverError server error
	 * @return data response
	 */
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InternalServerError.class)
	@ResponseBody
	public DataResponse<Object> globalInternalServerErrorHandler(InternalServerError serverError) {
		log.error("InternalServerErrorHandler: " + serverError.fillInStackTrace());
		return new DataResponse<>(Boolean.FALSE, ERROR_INTERNO, null);
	}

	/**
	 * Not found handler.
	 *
	 * @param notfound notfound
	 * @return data response
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundInvexException.class)
	@ResponseBody
	public DataResponse<Object> notFoundHandler(NotFoundInvexException notfound) {
		log.error("Not Found Error: " + notfound.getMessage());
		return new DataResponse<>(notfound.getSuccess(), notfound.getMessage(), notfound.getErrorCode(), null);
	}

}
