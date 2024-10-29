package com.hcl.app.repository;

import org.springframework.stereotype.Repository;

import com.hcl.app.entity.BloodRequests;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface BloodRequestsRepository extends JpaRepository<BloodRequests, Long>{

	List<BloodRequests> findByBloodGroup(String bloodGroup);
	
}
