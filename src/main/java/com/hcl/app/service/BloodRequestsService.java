package com.hcl.app.service;

import java.util.List;

import com.hcl.app.entity.BloodRequests;

public interface BloodRequestsService {
	BloodRequests saveRequest(BloodRequests req);
	List<BloodRequests> getAllRequests();
	void updateStatus(Long requestId, String newStatus);
	BloodRequests getRequestById(Long requestId);
	void deleteEntry(Long requestId); 
}
