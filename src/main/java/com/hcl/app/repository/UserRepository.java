package com.hcl.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.app.entity.Donor;
@Repository
public interface UserRepository extends JpaRepository<com.hcl.app.entity.Donor, Long>{
	Donor findByPhone(String phone);

	List<Donor> findByBloodGroup(String bloodGroup);
}
