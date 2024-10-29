package com.hcl.app.service;

import com.hcl.app.entity.Donor;
import java.util.List;

public interface UserService {
    Donor saveUser(Donor user);
    List<Donor> getAllUsers();	
	Donor getDonorById(Long userId);
	Donor findById(Long id);
	void deleteUserById(Long id);
	boolean isBloodAvailable(String bloodGroup);
}
