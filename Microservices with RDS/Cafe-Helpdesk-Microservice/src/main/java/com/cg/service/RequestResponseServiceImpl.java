package com.cg.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.RequestResponse;
import com.cg.repo.RequestResponseRepo;

@Service
@Transactional
public class RequestResponseServiceImpl implements RequestResponseService {

	@Autowired
	private RequestResponseRepo repo;
	
	@Override
	public RequestResponse addRequestResponse(RequestResponse requestResponse) {
		return repo.save(requestResponse);
	}
}
