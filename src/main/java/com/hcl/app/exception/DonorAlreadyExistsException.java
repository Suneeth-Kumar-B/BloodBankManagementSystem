package com.hcl.app.exception;

public class DonorAlreadyExistsException extends RuntimeException{
	public DonorAlreadyExistsException() {
		super("Donor with phone already exists!!!");
	}
}
