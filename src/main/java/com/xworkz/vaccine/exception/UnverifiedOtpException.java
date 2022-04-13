package com.xworkz.vaccine.exception;

@SuppressWarnings("serial")
public class UnverifiedOtpException extends RuntimeException{

	public UnverifiedOtpException(String message) {
		super(message);
	}
}
