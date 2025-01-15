package com.rays.exception;

/**
 * ApplicationException is propogated from Service classes when an business
 * logic exception occurered. 
 * Lokesh Solanki
 */
public class ApplicationException extends Exception {

	public ApplicationException(String msg) { // checked exception
		super(msg);
	}
}