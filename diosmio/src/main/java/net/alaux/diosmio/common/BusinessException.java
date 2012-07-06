package net.alaux.diosmio.common;

public class BusinessException extends Exception {

	public static final String FILE_ALREADY_EXISTS = "error.file_already_exists";

	// private Properties messages = new Properties

	public BusinessException(String exceptionKey) {
		super(exceptionKey);
	}
}
