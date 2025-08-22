/**
 * 
 */
package com.invex.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author EduSam
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DataResponse<T> extends SimpleResponse {

	/** data. */
	private T data;

	/**
	 * Creates a new instance of data response.
	 */
	public DataResponse() {
		this.setSuccess(false);
		this.setError("");
	}

	/**
	 * Creates a new instance of data response.
	 *
	 * @param error error
	 */
	public DataResponse(String error) {
		this.setSuccess(false);
		this.setError(error);
	}

	/**
	 * Creates a new instance of data response.
	 *
	 * @param success success
	 * @param error   error
	 * @param data    data
	 */
	public DataResponse(Boolean success, String error, T data) {
		this.setSuccess(success);
		this.setError(error);
		this.data = data;
	}

	/**
	 * Creates a new instance of data response.
	 *
	 * @param success success
	 * @param error   error
	 * @param code    code
	 * @param data    data
	 */
	public DataResponse(Boolean success, String error, Integer code, T data) {
		this.setSuccess(success);
		this.setError(error);
		this.setCode(code);
		this.setData(data);
	}

}
