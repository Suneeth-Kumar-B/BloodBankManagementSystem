package com.hcl.app.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	String errorMessage = "errorMessage";
	String errorPage = "errorPage";
	

	@ExceptionHandler(UsernameAlreadyExistsException.class)
    public String handleUsernameAlreadyExistsException(UsernameAlreadyExistsException ex, Model model) {
        model.addAttribute(errorMessage, ex.getMessage());
        return errorPage;
    }
	
	@ExceptionHandler(DonorAlreadyExistsException.class)
    public String handleDonorAlreadyExistsException(DonorAlreadyExistsException ex, Model model) {
        model.addAttribute(errorMessage, ex.getMessage());
        return errorPage;
    }
	
	@ExceptionHandler(RequestAlreadyRaisedException.class)
	public String handleRequestAlreadyRaisedException(RequestAlreadyRaisedException ex, Model model) {
		model.addAttribute(errorMessage,ex.getMessage());
		return errorPage;
	}
}