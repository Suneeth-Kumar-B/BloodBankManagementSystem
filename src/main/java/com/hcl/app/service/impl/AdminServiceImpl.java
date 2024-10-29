package com.hcl.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.app.entity.Admin;
import com.hcl.app.repository.AdminRepository;
import com.hcl.app.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	
	private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
	
	@Override
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}
	
	@Transactional(readOnly = true)
    public boolean validateAdmin(String username, String password) {
        Admin admin = adminRepository.findByUsernameAndPassword(username, password);
        return admin != null;
    }
}
