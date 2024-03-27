package com.Exception;

public class ApplicationDeadlineExceededException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//The serializable class ApplicationDeadlineExceededException does not declare a static final serialVersionUID field of type long
	public ApplicationDeadlineExceededException(String message) {
        super(message);
	}
}
