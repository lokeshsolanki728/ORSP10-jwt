package com.rays.exception;

/**
 * DatabaseException is propogated by DAO classes when an unhandled Database
 * exception occurred
 * Lokesh Solanki
 */
public class DatabaseException extends RuntimeException {
	public DatabaseException(String msg) { // Unchecked exception
		super(msg);
	}
}