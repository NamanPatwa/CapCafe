package com.cg.service;

import com.cg.dto.Employee;

public interface UserDetailService {
	Employee addNewUser(Employee user);
	Employee getById(String userId);
}
