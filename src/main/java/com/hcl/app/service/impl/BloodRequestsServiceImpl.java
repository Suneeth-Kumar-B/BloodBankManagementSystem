package com.hcl.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.app.entity.BloodRequests;
import com.hcl.app.repository.BloodRequestsRepository;
import com.hcl.app.service.BloodRequestsService;

@Service
public class BloodRequestsServiceImpl implements BloodRequestsService {

	private final BloodRequestsRepository bloodRequestsRepository;

    public BloodRequestsServiceImpl(BloodRequestsRepository bloodRequestsRepository) {
        this.bloodRequestsRepository = bloodRequestsRepository;
    }
	@Override
	public BloodRequests saveRequest(BloodRequests req) {
		return bloodRequestsRepository.save(req);
	}

	@Override
	public List<BloodRequests> getAllRequests() {
		return bloodRequestsRepository.findAll();
	}

	@Override
	public void updateStatus(Long requestId, String newStatus) {
		BloodRequests bloodRequest = bloodRequestsRepository.findById(requestId)
                .orElseThrow(() -> new IllegalArgumentException("Blood Request not found with ID: " + requestId));

        // Update the status of the BloodRequest entity
        bloodRequest.setStatus(newStatus);

        // Save the updated entity back to the database
        bloodRequestsRepository.save(bloodRequest);		
	}
	
	@Override
	public BloodRequests getRequestById(Long requestId) {
	    return bloodRequestsRepository.findById(requestId).orElse(null);
	}

	
	@Override
    public void deleteEntry(Long requestId) {
        bloodRequestsRepository.deleteById(requestId);
    }	
}
