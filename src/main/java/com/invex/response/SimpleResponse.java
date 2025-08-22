/**
 * 
 */
package com.invex.response;

import lombok.Data;

/**
 * @author EduSam
 *
 */
@Data
public class SimpleResponse {

	/** success. */
	private Boolean success;

	/** error. */
	private String error;

	/** code. */
	private Integer code;

	/**
	 * Creates a new instance of simple response.
	 */
	public SimpleResponse() {
		this.success = false;
		this.error = "";
		this.code = null;
	}

	/**
	 * Creates a new instance of simple response.
	 *
	 * @param error error
	 */
	public SimpleResponse(String error) {
		this.success = false;
		this.error = error;
		this.code = null;
	}

	/**
	 * Creates a new instance of simple response.
	 *
	 * @param success success
	 * @param error   error
	 */
	public SimpleResponse(Boolean success, String error) {
		this.success = success;
		this.error = error;
		this.code = null;
	}

	/**
	 * Creates a new instance of simple response.
	 *
	 * @param success success
	 * @param code    code
	 * @param error   error
	 */
	public SimpleResponse(Boolean success, Integer code, String error) {
		this.success = success;
		this.error = error;
		this.code = code;
	}
}
