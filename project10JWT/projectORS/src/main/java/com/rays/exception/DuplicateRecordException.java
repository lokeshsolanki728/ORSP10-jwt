package com.rays.exception;

/**
 * DuplicateRecordException thrown when a duplicate record occurred
 * Lokesh Solanki
 */
public class DuplicateRecordException extends RuntimeException {

	public DuplicateRecordException(String msg) { // Unchecked exception
		super(msg);
	}

}