package com.cg.service;


import java.util.InputMismatchException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entity.Ticket;
import com.cg.exception.OrderNotFoundException;
import com.cg.exception.TicketNotFoundException;
import com.cg.entity.Orders;
import com.cg.entity.RequestResponse;
import com.cg.repo.OrderRepo;
import com.cg.repo.TicketRepo;

/**
 * This is Service Implementation of Helpdesk Service
 * @author Bhushan Sonawane
 * @version 1.0
 */
@Service
@Transactional(rollbackFor = {OrderNotFoundException.class, TicketNotFoundException.class})
public class HelpdeskServiceImpl implements HelpdeskService {

	@Autowired
	private TicketRepo ticketRepo;
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private RequestResponseService requestResponseService;
	
	@Autowired
	private OrderService orderSerice;
	
	static Logger myLogger =  Logger.getLogger(HelpdeskServiceImpl.class);
	
	@Override
	public Ticket raiseTicket(int orderId, String message) throws OrderNotFoundException {
		myLogger.info("<<Raise Ticket service>>");
		if(message == null) {
			myLogger.error("Message is empty");
			throw new InputMismatchException("Message cannot be empty");
		}
		Orders order;
		try {
			order = orderSerice.getById(orderId);
			myLogger.info("Order with Order ID: " + orderId + " found");
		} catch (Exception e) {
			myLogger.error("Order with Order ID: " + orderId + " not found");
			throw new OrderNotFoundException("Order with Order ID: " + orderId + " not found");
		}
		
		Ticket ticket = ticketRepo.getByOrder(order);	
			
		// check if ticket exists with that id
		// if does not exist then create a new one 
			
		if(ticket == null) {
			myLogger.info("Creating new ticket");
			RequestResponse requestResponse = new RequestResponse();
			// setting ticket values
			ticket = new Ticket();
			ticket.setOrder(order);
			ticket.setLocation(order.getLocation());
			ticket = ticketRepo.save(ticket);		//saving helpdesk to database
			myLogger.info("Ticket persisted");

			// creating request response object
			myLogger.info("Creating request response object");
			requestResponse.setMessage(message);	
			requestResponse.setQuery(ticket);
			requestResponse.setType("Request");
			requestResponseService.addRequestResponse(requestResponse); // adding to database
			myLogger.info("Response object persisted");
			Ticket t = ticketRepo.getByOrder(order);
			return t;
		} else {
			// if already exists then only add request-response
			myLogger.info("Ticket already exists add request-response");
			RequestResponse requestResponse = new RequestResponse();
			requestResponse.setMessage(message);
			requestResponse.setQuery(ticket);
			requestResponse.setType("Request");
			requestResponseService.addRequestResponse(requestResponse);
			return ticket;
		}
	}


	@Override
	public Ticket getByTicketNumber(int id) throws TicketNotFoundException {
		myLogger.info("<<Get by ticket number service>>");
		Ticket ticket;
		try {
			ticket = ticketRepo.findById(id).get();
			myLogger.info("Ticket found for ID: "+id);
			return ticket;
		} catch (Exception e) {
			myLogger.info("Ticket not found for ID: "+id);
			throw new TicketNotFoundException("Ticket with given ID: " + id + " not found");
		}
	}
	
	@Override
	public List<Ticket> listAllTickets() {
		myLogger.info("<<List all Ticket service>>");
		return ticketRepo.findAll();
	}
	
	@Override
	public List<Ticket> listUnresolvedTickets() {
		myLogger.info("<<List Unresolved Ticket service>>");
		return ticketRepo.listUnresolvedTickets();
	}

	@Override
	public List<Ticket> listResolvedTickets() {
		myLogger.info("<<List resolved Ticket service>>");
		return ticketRepo.listResolvedTickets();
	}
	
	@Override
	public int markAsResolved(int ticketNumber) throws TicketNotFoundException {
		myLogger.info("<<Mark as resolved service>>");
		try {
			ticketRepo.findById(ticketNumber).get();
			return ticketRepo.markAsResolved(ticketNumber);
		} catch (Exception e) {
			throw new TicketNotFoundException("Ticket with ID: " + ticketNumber + " not found");
		}
	}
	
	@Override
	public Ticket sendResponse(int ticketNumber, String message) throws TicketNotFoundException {
		myLogger.info("<<Send response service>>");
		if(message == null) {
			throw new InputMismatchException("Message cannot be null");
		}
		try {
			Ticket ticket = ticketRepo.findById(ticketNumber).get();
			RequestResponse requestResponse = new RequestResponse();
			requestResponse.setMessage(message);
			requestResponse.setQuery(ticket);
			requestResponse.setType("Response");
			requestResponseService.addRequestResponse(requestResponse);
			return ticket;
		} catch (Exception e) {
			throw new TicketNotFoundException("Ticket with ID: " + ticketNumber + " not found");
		}
	}
	
	@Override
	public Ticket getByOrderId(int orderId) throws TicketNotFoundException, OrderNotFoundException {
		myLogger.info("<<Get by order id service>>");
		Orders order;
		try {
			order = orderSerice.getById(orderId);
		} catch (Exception e) {
			throw new OrderNotFoundException("Order not found with ID: " + orderId );
		}
		
		try {
			Ticket ticket = ticketRepo.getByOrder(order);
			return ticket;
		} catch (Exception e) {
			throw new TicketNotFoundException("Ticket Not Found");
		}
	}
	
	
	@Override
	public int countResolvedQueries() {
		myLogger.info("<<Count resolved queries service>>");
		return ticketRepo.countResolvedQueries();
	}

	@Override
	public int countUnresolvedQueries() {
		myLogger.info("<<Count Unresolved queries service>>");
		return ticketRepo.countUnresolvedQueries();
	}
	
	@Override
	public List<Ticket> getByLocation(String location) throws TicketNotFoundException {
		myLogger.info("<<Get tickets by location service>>");
		List<Ticket> tickets =  ticketRepo.getByLocation(location);
		if(tickets.size() == 0) {
			throw new TicketNotFoundException("Ticket with given location not found");
		}
		return tickets;
	}
	
	///////////////Order Related /////////////
	@Override
	public List<Orders> getAllOrders() {
		myLogger.info("<<Get all orders service>>");
		return orderRepo.findAll();
	}
	
	@Override
	public Orders addNewOrder(Orders order) {
		myLogger.info("<<Add new order service>>");
		return orderRepo.save(order);
	}

	@Override
	public Orders getById(int orderId) {
		myLogger.info("<<Get by id service>>");
		return orderRepo.findById(orderId).get();
	}
	//////////////////////////////////////////
}
