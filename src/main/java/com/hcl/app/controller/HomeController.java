package com.hcl.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.app.entity.Donor;
import com.hcl.app.exception.DonorAlreadyExistsException;
import com.hcl.app.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	private static final String LOGIN_ACTION_ATTR = "adminLoggedIn";
	
	String promptMessage = "promptMessage";
	
	private final UserService userService;
	
	String message = "promptMessage";
	
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "home"; // Assuming "home.jsp" exists in your views directory
    }

    @PostMapping("/newDonorRegister")
    public String registerDonor(@ModelAttribute Donor u, Model model){
    	try {
    		userService.saveUser(u);
    		model.addAttribute(promptMessage, "Registered as Donor Successfully!!!");
    		logger.info("New User Registered");
    		return promptMessage;
    	}catch(DataIntegrityViolationException ex) {
    		logger.error("DataIntegrityViolationException due to duplicate phonenumber");
    		throw new DonorAlreadyExistsException();
    	}
    }

    @RequestMapping("/showDonors")
    public ModelAndView showDonor(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        ModelAndView mv = new ModelAndView();
        
        if (session != null && session.getAttribute("adminLoggedIn") != null && (boolean) session.getAttribute("adminLoggedIn")) {
            // If session is active, proceed with showing donors
            mv.addObject("data", userService.getAllUsers());
            mv.setViewName("showDonors");
        } else {
            // If session is not active, redirect to adminLogin
            mv.setViewName("redirect:/adminLogin");
        }        
        return mv;
    }
    
    @GetMapping("/viewDonors")
    public ModelAndView viewDonors() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("data", userService.getAllUsers());
        mv.setViewName("viewDonors");
        return mv;
    }
    
    @GetMapping("/editDonor")
    public String editDonor(HttpServletRequest request) {
    	HttpSession session = request.getSession(false);
    	if (session != null && session.getAttribute(LOGIN_ACTION_ATTR) != null && (boolean) session.getAttribute(LOGIN_ACTION_ATTR))
    	return "editDonor";
    	return "adminLogin";
    }
    
    @PostMapping("/updateDonor")
    public String updateDonor(@RequestParam("id") Long id,
                               @RequestParam("name") String name,
                               @RequestParam("bloodGroup") String bloodGroup,
                               @RequestParam("phone") String phone,
                               @RequestParam("city") String city,
                               Model model)throws DonorAlreadyExistsException {
    	try {
        Donor donor = userService.findById(id);
        if (donor != null) {
            donor.setName(name);
            donor.setBloodGroup(bloodGroup);
            donor.setPhone(phone);
            donor.setCity(city);
            userService.saveUser(donor); // Save updated donor information
            model.addAttribute(promptMessage, "Donor updated successfully");
            logger.info("Donor with ID:{} updated",donor.getUserID());
        }
        else
        {
        	model.addAttribute(promptMessage,"No such donor exist");
        }
        }catch(DataIntegrityViolationException ex) {
        	logger.error("DataIntegrityViolationException due to duplicate phonenumber");
            model.addAttribute(promptMessage, "Failed to update donor. Phone already exists");
        }
        return promptMessage; // Return the view name where you display the prompt message
    }
    
    @PostMapping("/deleteDonor")
    public String deleteDonor(@RequestParam("id") Long id, Model model) {
        userService.deleteUserById(id);
        logger.info("Donor with ID:{} deleted",id);
        model.addAttribute(promptMessage, "Donor deleted successfully");
        return promptMessage;
    }

    
    @PostMapping("/checkAvailability")
    public String checkAvailability(String bloodGroup, Model model) {
        boolean isAvailable = userService.isBloodAvailable(bloodGroup);
        if (isAvailable) {
            model.addAttribute(message, "Blood is available for the group: " + bloodGroup);
        } else {
            model.addAttribute(message, "Blood is not available for the group: " + bloodGroup);
        }
        return message;
    }

}
