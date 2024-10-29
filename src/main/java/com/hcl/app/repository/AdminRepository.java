package com.hcl.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hcl.app.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
	Admin findByUsernameAndPassword(String username, String password);
}
