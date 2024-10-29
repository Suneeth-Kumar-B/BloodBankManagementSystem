package com.hcl.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationPageController {	
    @GetMapping("/donorRegister")
    public String showUserRegistrationForm() {
        return "donorRegister"; // Return the name of the JSP file
    }    
}