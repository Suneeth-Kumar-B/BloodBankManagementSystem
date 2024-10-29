package com.hcl.app.service;

import java.util.List;

import com.hcl.app.entity.Admin;

public interface AdminService {
	Admin saveAdmin(Admin admin);
	List<Admin> getAllAdmins();
	boolean validateAdmin(String username, String password);
}
