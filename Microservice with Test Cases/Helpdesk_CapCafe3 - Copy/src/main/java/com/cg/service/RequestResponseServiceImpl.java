package com.cg.service;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.RequestResponse;
import com.cg.repo.RequestResponseRepo;

/**
 * Request Response service Implementation class
 * @author Bhushan Sonawane
 * @version 1.0
 */
@Service
@Transactional
public class RequestResponseServiceImpl implements RequestResponseService {

	@Autowired
	private RequestResponseRepo repo;
	
	static Logger myLogger =  Logger.getLogger(OrderServiceImpl.class);

	/**
	 * To add a request or response to database
	 */
	@Override
	public RequestResponse addRequestResponse(RequestResponse requestResponse) {
		myLogger.info("<<Add request response service>>");
		return repo.save(requestResponse);
	}
}
