package com.training.Sprint1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.Sprint1.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long>{
	
}
