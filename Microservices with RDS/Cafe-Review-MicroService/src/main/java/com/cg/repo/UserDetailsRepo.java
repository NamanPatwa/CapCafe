package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.dto.Employee;

public interface UserDetailsRepo extends JpaRepository <Employee,String> {

}
