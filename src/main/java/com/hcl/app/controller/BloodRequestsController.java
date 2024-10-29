package com.hcl.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.app.entity.BloodRequests;
import com.hcl.app.exception.RequestAlreadyRaisedException;
import com.hcl.app.service.BloodRequestsService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BloodRequestsController {
	private static final Logger logger = LoggerFactory.getLogger(BloodRequestsController.class);
	private final BloodRequestsService bloodRequestsService;
	
	String message = "promptMessage";
    public BloodRequestsController(BloodRequestsService bloodRequestsService) {
        this.bloodRequestsService = bloodRequestsService;
    }
	@GetMapping("/bloodRequestsPage")
	public String bloodRequestsPage(){
		return "bloodRequestsForm";		
	}
	
	@PostMapping("/deleteEntry")
    public String deleteEntry(@RequestParam Long requestId, Model model) {
        (bloodRequestsService).deleteEntry(requestId);
        model.addAttribute(message, "Entry Deleted");
        return "promptMessage";
    }
	
	@PostMapping("/saveRequest")
    public String newRequest(@ModelAttribute BloodRequests req, Model model) {
    	try {
    		bloodRequestsService.saveRequest(req);
    		model.addAttribute(message, "Request Generated with ID: "+req.getBloodRequestId());
    		logger.info("New Request Raised. ID: {}",req.getBloodRequestId());
            return message;
        } catch (DataIntegrityViolationException ex) {
        	throw new RequestAlreadyRaisedException();
        }
    }
	
	@GetMapping("/showBloodRequests")
	public ModelAndView showBloodRequests(HttpServletRequest request) {
	    HttpSession session = request.getSession(false); // Retrieve existing session, if any
	    
	    // Check if the session exists and if the admin is logged in
	    if (session != null && session.getAttribute("adminLoggedIn") != null && (boolean) session.getAttribute("adminLoggedIn")) {
	        // Session is active and admin is logged in, proceed to show blood requests
	        ModelAndView mv = new ModelAndView();
	        mv.addObject("data", bloodRequestsService.getAllRequests());
	        mv.setViewName("showBloodRequests");
	        return mv;
	    } else {
	        // Session is not active or admin is not logged in, redirect to admin login page
	        return new ModelAndView("redirect:/adminLoginPage");
	    }
	}

	
	@PostMapping("/updateStatus")
    public String updateStatus(@RequestParam("requestId") Long requestId, @RequestParam("newStatus") String newStatus) {
        // Call a service method to update the status in the database
        bloodRequestsService.updateStatus(requestId, newStatus);
        logger.info("Status Updated for ID: {} {}",requestId,newStatus);
        return "Status updated successfully";
    }

    @GetMapping("/checkStatusPage")
    public String checkStatusPage() {
    	return "checkStatus";
    }
    
    @GetMapping("/checkAvailabilityPage")
    public String bloodRequestForm() {
    	return "checkBloodAvailabilityPage";
    }
    
    
    
    @PostMapping("/requestStatus")
    public String checkStatus(@RequestParam("requestId") Long requestId, Model model) {
        // Retrieve blood request details based on request ID
        BloodRequests bloodRequest = bloodRequestsService.getRequestById(requestId);

        if (bloodRequest != null) {
            // If request found, add it to the model and return details view
            model.addAttribute("bloodRequest", bloodRequest);
            return "requestStatus";
        } else {
            // If request not found, return error view
            model.addAttribute("errorMessage", "Blood request with ID " + requestId + " not found.");
        	logger.error("No request found for ID: {}",requestId);
            return "errorPage";
        }
    }
}
