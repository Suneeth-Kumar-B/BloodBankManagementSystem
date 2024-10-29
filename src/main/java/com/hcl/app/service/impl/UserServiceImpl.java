package com.hcl.app.service.impl;

import com.hcl.app.entity.Donor;
import com.hcl.app.repository.UserRepository;
import com.hcl.app.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Donor saveUser(Donor user) {
        return userRepository.save(user);
    }

    @Override
    public List<Donor> getAllUsers() {
        return userRepository.findAll();
    }
    
    @Override
    public Donor getDonorById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
    
    @Override
    public Donor findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    
    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean isBloodAvailable(String bloodGroup) {
        List<Donor> bloodRequests = userRepository.findByBloodGroup(bloodGroup);
        return !bloodRequests.isEmpty();
    }

}
