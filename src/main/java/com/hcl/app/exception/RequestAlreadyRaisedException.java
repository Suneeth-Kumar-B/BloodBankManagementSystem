package com.hcl.app.exception;

public class RequestAlreadyRaisedException extends RuntimeException{
	public RequestAlreadyRaisedException() {
		super("Request already raised!!!");
	}
}
