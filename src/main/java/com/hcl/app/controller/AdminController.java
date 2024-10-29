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
import com.hcl.app.entity.Admin;
import com.hcl.app.exception.UsernameAlreadyExistsException;
import com.hcl.app.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	
    private final AdminService adminService;
    
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    
    private static final String LOGIN_ACTION_ATTR = "adminLoggedIn";

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/adminRegistrationPage")
    public String adminRegister() {
        return "adminRegister";
    }

    @GetMapping("/adminLoginPage")
    public String adminLogin(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute(LOGIN_ACTION_ATTR) != null && (boolean) session.getAttribute(LOGIN_ACTION_ATTR)) {
            logger.info("Admin session is active.");
            return "redirect:/adminHome";
        } else {
            return "adminLogin";
        }
    }

    @PostMapping("/newAdmin")
    public String register(@ModelAttribute Admin a, Model model) {
        try {
            adminService.saveAdmin(a);
            model.addAttribute("promptMessage", "Successfully Registered as Admin.");
            return "promptMessage";
        } catch (DataIntegrityViolationException ex) {
            logger.error("Error occurred while registering admin {}", ex);
            throw new UsernameAlreadyExistsException();
        }
    }

    @PostMapping("/adminLogin")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpServletRequest request2,
                        HttpServletRequest request,
                        HttpServletResponse response) {
        boolean isValidAdmin = adminService.validateAdmin(username, password);

        if (isValidAdmin) {
            HttpSession session = request.getSession(true);
            session.setAttribute(LOGIN_ACTION_ATTR, true);
            session.setMaxInactiveInterval(120);
            logger.info("Admin logged in: {}", username);
            return "redirect:/adminHome";
        } else {
            request2.setAttribute("errorMessage", "Invalid username or password!!!");
            return "errorPage";
        }
    }

    @GetMapping("/adminHome")
    public String adminControls(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute(LOGIN_ACTION_ATTR) != null && (boolean) session.getAttribute(LOGIN_ACTION_ATTR)) {
            logger.info("Admin session is active.");
            return "adminHome";
        } else {
        	logger.info("Session Inactive");
            return "redirect:/adminLoginPage";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
            logger.info("Admin session invalidated.");
        }

        return "redirect:/adminLoginPage";
    }
}
